package testing;

import org.testng.Assert;

public class Topic_01_Assertion {

    public static void main(String[] args) {
        //3 hàm chính để kiểm tra tính đúng đăn của dữ liệu
        boolean gender = 3 > 5 ;
        //kt đúng
        Assert.assertTrue(gender);
        //kt sai
        Assert.assertFalse(gender);

        //kt đúng vs mong đợi



    }

}
