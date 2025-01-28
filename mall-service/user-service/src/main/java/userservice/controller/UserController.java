package userservice.controller;

import org.springframework.web.bind.annotation.*;
import userservice.dto.LoginFormDTO;
import userservice.dto.LogoutRequest;
import userservice.dto.RegisterUserDTO;
import userservice.dto.UpdateUserDTO;
import userservice.service.UserService;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import userservice.common.Result;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 用户注册
     * @param registerUserDTO 用户实体信息
     * @return 注册结果
     */
    @PostMapping("/register")
    public Result register(@RequestBody RegisterUserDTO registerUserDTO) {
        /// TODO 注册成功
        return Result.fail("注册失败，邮箱可能已被占用");
    }


    /**
     * 用户登录
     * @param loginForm 登录表单，包括邮箱和密码
     * @param session HttpSession会话
     * @return 登录结果，包含身份令牌
     */
    @PostMapping("/login")
    public Result login(@RequestBody LoginFormDTO loginForm, HttpSession session) {
        // TODO 登录成功
        return Result.fail("登录失败，邮箱或密码错误");
    }

    /**
     * 用户登出
     * @param session HttpSession会话
     * @return 登出结果
     */
    @PostMapping("/logout")
    public Result logout(@RequestBody LogoutRequest logoutRequest, HttpSession session) {
        // TODO 实现登出功能
        return Result.fail("功能未完成");
    }


    /**
     * 获取用户信息
     * @param userId 用户ID
     * @return 用户信息
     */
    @GetMapping("/info/{userId}")
    public Result getUserInfo(@PathVariable Long userId, @RequestHeader("Authorization") String token) {
        // TODO 返回查询详情
        return Result.fail("未找到用户信息");
    }


    /**
     * 更新用户信息
     * @param updateUserDTO 用户实体信息
     * @return 更新结果
     */
    @PutMapping("/update")
    public Result updateUser(@RequestBody UpdateUserDTO updateUserDTO) {
        // TODO 用户信息更新
        return Result.fail("用户信息更新失败");
    }

    /**
     * 删除用户
     * @param userId 用户ID
     * @return 删除结果
     */
    @DeleteMapping("/delete/{userId}")
    public Result deleteUser(@PathVariable Long userId) {
        // TODO 删除用户
        return Result.fail("用户删除失败");
    }
}


