package life.lq.kingcommunity.Service;

import life.lq.kingcommunity.mapper.UserMapper;
import life.lq.kingcommunity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public void createOrUpdate(User user) {
       User dbuser = userMapper.findByAccountId(user.getAccountId());
       if(dbuser == null){
           userMapper.insert(user);
       }else {
           dbuser.setGmtModified(System.currentTimeMillis());
           dbuser.setAvatarUrl(user.getAvatarUrl());
           dbuser.setName(user.getName());
           dbuser.setToken(user.getToken());
           userMapper.update(dbuser);
       }
    }
}
