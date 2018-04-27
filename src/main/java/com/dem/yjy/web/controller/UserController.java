package com.dem.yjy.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dem.yjy.web.enums.MessageColor;
import com.dem.yjy.web.model.User;
import com.dem.yjy.web.security.PermissionSign;
import com.dem.yjy.web.security.RoleSign;
import com.dem.yjy.web.service.UserService;

/**
 * 用户控制器
 * 
 * @author StarZou
 * @since 2014年5月28日 下午3:54:00
 **/
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 用户登录
     * 
     * @param user
     * @param result
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@Valid User user, BindingResult result, Model model, HttpServletRequest request) {
        try {
            Subject subject = SecurityUtils.getSubject();
            // 已登陆则 跳到首页
            if (subject.isAuthenticated()) {
                return "index";
            }
            if (result.hasErrors()) {
                model.addAttribute("error", "参数错误！");
                return "login";
            }
            // 身份验证
            subject.login(new UsernamePasswordToken(user.getUsername(), user.getPassword()));
            // 验证成功在Session中保存用户信息
            final User authUserInfo = userService.selectByUsername(user.getUsername());
            request.getSession().setAttribute("userInfo", authUserInfo);
        } catch (AuthenticationException e) {
            // 身份验证失败
            model.addAttribute("error", "用户名或密码错误 ！");
            return "login";
        }
        return "index";
    }

    /**
     * 用户登出
     * 
     * @param session
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("userInfo");
        // 登出操作
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }

    /**
     * 基于角色 标识的权限控制案例
     */
    @RequestMapping(value = "/admin")
    @ResponseBody
    @RequiresRoles(value = RoleSign.ADMIN)
    public String admin() {
        return "拥有admin角色,能访问";
    }

    /**
     * 基于权限标识的权限控制案例
     */
    @RequestMapping(value = "/create")
    @ResponseBody
    @RequiresPermissions(value = PermissionSign.USER_CREATE)
    public String create() {
        return "拥有user:create权限,能访问";
    }

	@RequestMapping(value = "/mine")
	public String mine(Model model, HttpSession session) {
		final User userInfo = (User) session.getAttribute("userInfo");
		if (userInfo != null && userInfo.getId() != null && 0L != userInfo.getId()) {
			final User user = userService.selectById(userInfo.getId());
			model.addAttribute("user", user);
			return "mine";
		} else {
			return "login";
		}
	}

	@RequestMapping(value = "/psw")
	public String psw(@Valid User user, Model model, HttpServletRequest request) {
		String password0 = request.getParameter("password0");
		if (user != null && user.getPassword() != null && !DigestUtils.sha256Hex("").equals(user.getPassword())) {
			if (password0.equals(user.getPassword())) {
				final int count = userService.update(user);
				if (count > 0) {
					model.addAttribute("msg0", MessageColor.SUCCESS.getColor());
					model.addAttribute("msg", "修改密码成功");
					final User userInfo = (User) request.getSession().getAttribute("userInfo");
					model.addAttribute("user", userInfo);
					return "mine";
				} else {
					model.addAttribute("msg", "修改密码失败");
				}
			} else {
				model.addAttribute("msg", "修改密码失败，两次输入密码不一致");
			}
		} else {
			model.addAttribute("msg", "修改密码失败，密码不能为空");
		}
		model.addAttribute("msg0", MessageColor.FAILURE.getColor());
		final User userInfo = (User) request.getSession().getAttribute("userInfo");
		model.addAttribute("user", userInfo);
		return "mine";
	}
}
