package com.yidiansishiyi.searchCenter.datasource;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yidiansishiyi.searchCenter.model.dto.user.UserQueryRequest;
import com.yidiansishiyi.searchCenter.model.vo.UserVO;
import com.yidiansishiyi.searchCenter.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户服务实现
 *
 * @author sanqi
 */
@Service
@Slf4j
public class UserDataSource implements DataSource<UserVO> {

    @Resource
    private UserService userService;
    @Override
    public Page<UserVO> doSearch(String searchText, long pageNum, long pageSize) {
        UserQueryRequest userQueryRequest = new UserQueryRequest();
        userQueryRequest.setUserName(searchText);
        userQueryRequest.setPageSize(pageSize);
        userQueryRequest.setCurrent(pageNum);
        Page<UserVO> userVOPage = userService.listUserVOByPage(userQueryRequest);
        return userVOPage;
    }
}
