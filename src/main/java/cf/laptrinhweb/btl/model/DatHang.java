package cf.laptrinhweb.btl.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DatHang {
    private Long maDatHang;
    private Date creatAt;
    private String note;
    private int payment_method;
    private int shipping_method;
    private int status;
    private Long customer_user_id;
    private Long shipping_address_id;

}
