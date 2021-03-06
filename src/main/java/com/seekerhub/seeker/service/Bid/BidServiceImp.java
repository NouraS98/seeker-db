package com.seekerhub.seeker.service.Bid;

import com.seekerhub.seeker.dto.Bid.BidDto;
import com.seekerhub.seeker.dto.Contract.ContractDto;
import com.seekerhub.seeker.dto.Milestone.MilestoneDto;
import com.seekerhub.seeker.dto.Project.ProjectBasicDto;
import com.seekerhub.seeker.dto.Project.ProjectDto;
import com.seekerhub.seeker.entity.Bid;
import com.seekerhub.seeker.entity.Milestone;
import com.seekerhub.seeker.entity.Project;
import com.seekerhub.seeker.exception.GenericException;
import com.seekerhub.seeker.mapper.BidMapper;
import com.seekerhub.seeker.mapper.ContractMapper;
import com.seekerhub.seeker.mapper.FreelancerMapper;
import com.seekerhub.seeker.mapper.ProjectMapper;
import com.seekerhub.seeker.repository.BidRepository;
import com.seekerhub.seeker.repository.ProjectRepository;
import com.seekerhub.seeker.service.Contract.ContractService;
import com.seekerhub.seeker.service.Milestone.MilestoneService;
import com.seekerhub.seeker.service.Project.ProjectService;
import com.seekerhub.seeker.service.PushNotificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BidServiceImp implements BidService {
    @Autowired
    BidRepository bidRepository;
    @Autowired
    BidMapper bidMapper;

    @Autowired
    ContractService contractService;

    @Autowired
    MilestoneService milestoneService;

    @Autowired
    ContractMapper contractMapper;

    @Autowired
    ProjectService projectService;


    @Autowired
    ProjectMapper projectMapper;

    @Autowired
    FreelancerMapper freelancerMapper;

    @Autowired
    ProjectRepository projectRepository;


    @Autowired
    PushNotificationsService pushNotificationsService;

    @Override
    public BidDto save(BidDto bidDto) {
        Bid bid = bidMapper.toEntity(bidDto);
        bid.setStatus("pending");
        Bid bidToSave = bidRepository.save(bid);
        return bidMapper.toDto(bidToSave);
    }

    @Override
    public List<BidDto> findAll() {
        return bidMapper.toDtos(bidRepository.findAll());
    }

    @Override
    public BidDto findById(long id) {
        return bidMapper.toDto(bidRepository.getOne(id));
    }

    @Override
    @Transactional
    public ContractDto acceptBid(long id) {
        if (!bidRepository.existsById(id))
            throw new GenericException("bid doesn't exists");

        Bid bid = bidRepository.getOne(id);
        bid.setStatus("accepted");
        ContractDto contractDto = new ContractDto();

        contractDto.setDeadline(bid.getDeliver_date());
        contractDto.setPrice(bid.getPrice());
        contractDto.setProject(projectMapper.toDto(bid.getProject()));
        contractDto.setFreelancer(freelancerMapper.toDto(bid.getFreelancer()));


        //TODO مدري وش التايب
        // 0 - in-progress
        // 1 - completed
        contractDto.setType("0");
        ContractDto contact = contractService.save(contractDto);


        MilestoneDto  milestoneDto = new MilestoneDto();
        milestoneDto.setAmount(bid.getPrice());
        milestoneDto.setDeadline(bid.getDeliver_date());
        milestoneDto.setDescription(bid.getProject().getTitle());
        milestoneDto.setStatus("0");

        ProjectBasicDto project = new ProjectBasicDto();
        project.setId(bid.getProject().getId());
        project.setDescription(bid.getProject().getDescription());
        project.setTitle(bid.getProject().getTitle());
        project.setType(bid.getProject().getType());

        milestoneDto.setProject(project);

        MilestoneDto milestoneDto1 = milestoneService.save(milestoneDto);
//        bid.setContract(contractMapper.toEntity(contact));

        bidRepository.save(bid);

        projectService.setStatus(bid.getProject().getId());

        if(bid.getFreelancer().getUser().isEnableAcceptBidNoti() && bid.getFreelancer().getUser().isLogin())
        pushNotificationsService.sendAcceptBidNotification(bidMapper.toDto(bid),bid.getFreelancer().getUser().getToken_id());
        return contact;

    }
    /**
     *     //todo new 2 hind
     *     @Override
     *     public List<ProjectDto> findByStatus(String status) {
     *         if (!projectRepository.existsByStatus(status))
     *             throw new GenericException("No Projects");
     *
     *         return projectMapper.toDtos(projectRepository.findByStatus(status));
     *     }
     */

    @Override
    public List<BidDto> findBidByStatus(String status) {
        if (!bidRepository.existsByStatus(status))
            throw new GenericException("No Bids");

        return bidMapper.toDtos(bidRepository.findBidByStatus(status));

    }

    @Override
    public void deleteBidById(long id) {
        if (!bidRepository.existsById(id))
            throw new GenericException("Bid doesn't exist");

        bidRepository.deleteById(id);
    }

    @Override
    public void deleteBidByIdAdmin(long id) {
        if (!bidRepository.existsById(id))
            throw new GenericException("Bid doesn't exist");
        BidDto bid = findById(id);

        pushNotificationsService.sendDeletedByAdminNotification(bid,bid.getFreelancer().getUser().getToken_id());

        bidRepository.deleteById(id);


    }

    @Override
    public List<BidDto> findBidByProject(long project_id) {
        if (!projectRepository.existsById(project_id))
            throw new GenericException("Project doesn't exist");

        Project project = projectRepository.getOne(project_id);

        return bidMapper.toDtos(project.getBids());

    }
}
