
package utils;

import java.util.Scanner;

/*
Inputter là 1 cái khuôn nhưng anh ko dùng để úc ra object
mà anh dùng class này để lưu những hàm (method) hỗ trợ cho việc nhập
*/
public class Inputter {
    //props
    public static Scanner sc = new Scanner(System.in);
    //những method hỗ trợ cho việc nhập
    //method ép người dùng nhập số nguyên chuân r
    public static int getAnInteger(String inpMsg, String errMsg){
        System.out.println(inpMsg);//hiển thị câu mời nhập
        while(true){
            try {
                int number = Integer.parseInt(sc.nextLine());
                return number;
            } catch (Exception e) {
                System.out.println(errMsg);//hiển thị câu chửi
            }
        }
        
    }
    
    //method ép bắt nhập số nguyên chuẩn nhưng phải ở trong khoảng
    public static int getAnInteger(String inpMsg, String errMsg, int lowerBound, int upperBound){
        if(lowerBound > upperBound){//đổi chỗ nếu có người dùng khờ
            int tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        System.out.println(inpMsg);//hiển thị câu mời nhập
        while(true){
            try {
                int number = Integer.parseInt(sc.nextLine());
                if(number < lowerBound || number > upperBound){
                    throw new Exception();
                }
                return number;
            } catch (Exception e) {
                System.out.println(errMsg);//hiển thị câu chửi
            }
        }
        
    }
    
    //method ép người dùng nhập số thực chuẩn
    public static double getADouble(String inpMsg, String errMsg){
        System.out.println(inpMsg);//hiển thị câu mời nhập
        while(true){
            try {
                double number = Double.parseDouble(sc.nextLine());
                return number;
            } catch (Exception e) {
                System.out.println(errMsg);//hiển thị câu chửi
            }
        }
        
    }
    
    //method ép bắt nhập số thực chuẩn nhưng phải ở trong khoảng
    public static double getADouble(String inpMsg, String errMsg, double lowerBound, double upperBound){
        if(lowerBound > upperBound){//đổi chỗ nếu có người dùng khờ
            double tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        System.out.println(inpMsg);//hiển thị câu mời nhập
        while(true){
            try {
                double number = Double.parseDouble(sc.nextLine());
                if(number < lowerBound || number > upperBound){
                    throw new Exception();
                }
                return number;
            } catch (Exception e) {
                System.out.println(errMsg);//hiển thị câu chửi
            }
        }
    }
    
    //nhập chuỗi ko đc để trống 
    public static String getString(String inpMsg, String errMsg){
        System.out.println(inpMsg);
        while(true){
            try {
                String str = sc.nextLine();
                if(str.isEmpty()){
                    throw new Exception();
                }
                return str;
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }
    }
    
     //nhập chuỗi ko đc để trống và phải đúng regex 
    public static String getString(String inpMsg, String errMsg, String regex){
        System.out.println(inpMsg);
        while(true){
            try {
                String str = sc.nextLine();
                if(str.isEmpty() || !str.matches(regex)){
                    throw new Exception();
                }
                return str;
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }
    }
    
    //hàm nhập ngày tháng năm theo format 
    //f(câu mời, câu chưỡi, 'dd-mm-yyyy')
    
}
