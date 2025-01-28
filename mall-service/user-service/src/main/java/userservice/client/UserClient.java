package userservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import userservice.common.Result;

@FeignClient(name = "user-service", path = "/douyin/users")
public interface UserClient {

    // 获取用户信息
    @GetMapping("/info")
    Result getUserInfo(@RequestParam("user_id") Long userId);
}
