package mx.edu.utng.orders.sqlite;

import java.util.UUID;

/**
 * Created by tacho on 7/02/17.
 */

public class OrderContract {

    interface OrderHeaderColumns{
        String ID = "id";
        String DATE = "record_date";
        String ID_CUSTOMER = "id_customer";
        String ID_METHOD_PAYMENT = "id_method_payment";
        String ID_TITLE = "id_tile";
    }

    interface OrderDetailColumns{
        String ID = "id";
        String SEQUENCE = "sequence";
        String ID_PRODUCT = "id_product";
        String QUANTITY = "quantity";
        String PRICE = "price";
    }

    interface ProductColumns{
        String ID = "id";
        String NAME = "name";
        String PRICE = "price";
        String STOCK = "stock";
    }

    interface  CustomerColumns{
        String ID = "id";
        String FIRSTNAME = "firstname";
        String LASTNAME = "lastname";
        String PHONE = "phone";
    }

    interface  TitleColumns{
        String ID = "id";
        String TITLE = "title";
        String FROMDATE = "fromdate";
        String TODATE = "todate";
    }


    interface MethodPaymentColumns{
        String ID = "id";
        String NAME = "name";
    }

    public static class OrderHeaders implements OrderHeaderColumns{
        public static String generateIdOrderHeader(){
            return  "OH-"+ UUID.randomUUID().toString();
        }
    }

    public static class OrderDetails implements OrderDetailColumns{

    }

    public static class Products implements ProductColumns{
        public static String generateIdProduct(){
            return  "PR-"+ UUID.randomUUID().toString();
        }
    }

    public static class Titles implements TitleColumns{
        public static String generateIdTitle(){
            return  "PR-"+ UUID.randomUUID().toString();
        }
    }
    public static class Customers implements CustomerColumns{
        public static String generateIdCustomer(){
            return  "CU-"+ UUID.randomUUID().toString();
        }
    }

    public static class MethodsPayment implements MethodPaymentColumns{
        public static String generateIdMethodPayment(){
            return  "MP-"+ UUID.randomUUID().toString();
        }
    }

    private OrderContract() {

    }
}
