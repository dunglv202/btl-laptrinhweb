package cf.laptrinhweb.btl.service.impl;

import cf.laptrinhweb.btl.entity.TheLoai;
import cf.laptrinhweb.btl.service.TheLoaiService;

import java.util.ArrayList;
import java.util.List;

public class TheLoaiServiceImpl implements TheLoaiService {
    @Override
    public List<TheLoai> layTatCa() {
        List<TheLoai> dsTheLoai = new ArrayList<>();
        dsTheLoai.add(new TheLoai(
            1L,
            "Xoong nồi"
        ));
        dsTheLoai.add(new TheLoai(
            2L,
            "Bếp điện"
        ));
        dsTheLoai.add(new TheLoai(
            3L,
            "Hút mùi"
        ));
        dsTheLoai.add(new TheLoai(
            4L,
            "Đèn sưởi"
        ));
        dsTheLoai.add(new TheLoai(
            4L,
            "Máy xay"
        ));
        dsTheLoai.add(new TheLoai(
            5L,
            "Lò nướng"
        ));
        return dsTheLoai;
    }
}
