package SinbinZhou.Listener;

import SinbinZhou.View.LoginView;
import SinbinZhou.View.MainView;
import SinbinZhou.Model.AccountModel;
import SinbinZhou.Controller.LoginController;
import SinbinZhou.View.MyJOptionPane;

import java.awt.event.*;

/**
 * @ClassName: LoginListener
 * @UserName: SinBin
 * @date: 2023-07-06 15:02
 * @Description:
 * 登录界面两个按钮的监视器
 */
public class LoginListener implements ActionListener {
    private LoginView loginView;
    public LoginListener(LoginView loginView) {
        this.loginView = loginView;
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginView.getLoginButton() || e.getSource() == loginView.getPwdText()) {
            //从组件获取用户名和密码
            String usr = loginView.getUsrText().getText();
            char[] chars = loginView.getPwdText().getPassword();
            //验证是否为空
            if(usr == null || "".equals(usr.trim()) || chars == null) {
                MyJOptionPane.showMessageDialog(null, "请检查用户名和密码", "提示");
                return;
            }
            //把数据填入账户实体
            String pwd = new String(chars);
            AccountModel accountModel = new AccountModel();
            accountModel.setUsrName(usr);
            accountModel.setPwd(pwd);
            //向数据库查询验证账户密码
            boolean st = LoginController.accountVerify(accountModel);
            if(st) {
                loginView.dispose();
                new MainView();
            } else {
                MyJOptionPane.showMessageDialog(null, "请检查用户名和密码", "提示");
            }
        }
        //清空文本框
        if(e.getSource() == loginView.getResetButton()) {
            loginView.getUsrText().setText("");
            loginView.getPwdText().setText("");
        }
    }
}