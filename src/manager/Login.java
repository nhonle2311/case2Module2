package manager;

public interface Login {
    // Phương thức để kiểm tra việc đăng nhập
    boolean loginByIDPasword();

    // Phương thức để thay đổi mật khẩu
    boolean changePassword(String username, String oldPassword, String newPassword);
}

