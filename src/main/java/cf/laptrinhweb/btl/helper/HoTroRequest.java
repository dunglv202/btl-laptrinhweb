package cf.laptrinhweb.btl.helper;

import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import static java.nio.charset.StandardCharsets.UTF_8;

public class HoTroRequest {
    public static String layThamSo(HttpServletRequest request, String tenThamSo) {
        try {
            Part part = request.getParts()
                .stream()
                .filter(p -> p.getName().equalsIgnoreCase(tenThamSo))
                .findFirst()
                .orElse(null);
            return part == null ? null : IOUtils.toString(part.getInputStream(), UTF_8);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
