package cf.laptrinhweb.btl.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ThongBao {
    protected String anh = "https://static-00.iconduck.com/assets.00/golang-icon-398x512-eygvdisi.png";
    protected String tieuDe;
    protected String noiDung;
}
