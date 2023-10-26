package com.user;

public class Bill {

        //need to get the product_id and quantity entered by user

        static double bill;


        //8.Calculate bill- by Admin
        double makebill(int quantity,double Price){

            bill=quantity*Price;
            System.out.println("Your Bill is Calculated by Admin");
            return bill;
        }

        //9.Displaying the amount of bill to the enduser
        void showBillAmount() {

            System.out.println("Displaying the amount of Total Bill to EndUser>> "+ bill );
        }

        void CheckUserHistory(){

        }

        public static void main(String args[]) {

            Bill billpayment=new Bill();
            billpayment.makebill(3, 4000);
            billpayment.showBillAmount();


        }


    }

