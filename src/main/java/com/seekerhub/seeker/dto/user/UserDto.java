package com.seekerhub.seeker.dto.user;

import com.seekerhub.seeker.dto.role.RoleDto;
import com.seekerhub.seeker.dto.storageDocument.StorageDocumentDto;
import com.seekerhub.seeker.entity.StorageDocument;
import com.seekerhub.seeker.enums.RoleEnum;
import javassist.bytecode.ByteArray;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

//JSON هذا اللي بيرجع
//password بينشال
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {
    private long id;
    private String username;
    private Set<RoleDto> roles;
    private String email;
    private String phone_number;
    private String national_id;
    private String rating;
    private RoleEnum current_type;
    private StorageDocumentDto avatar;
    private String twitter;
    private String facebook;
    private String linkedIn;
    private String education;
    private String isEnabled;
    private byte[] img;
   private String token_id;
    private List<StorageDocument> sampleWorks = new ArrayList<>();
    private boolean verified;

    private boolean enableProjectExpiryNoti;

    private boolean enableProjectSkillNoti;

    private boolean enableAcceptBidNoti;

    private boolean enableMilestoneDLNoti;

}
