package com.zzk.service.loginRelated;

import com.zzk.entity.po.UserPermissionsRelated.User;
import com.zzk.entity.response.R;

public interface LoginService {

    R login(User user);
}
