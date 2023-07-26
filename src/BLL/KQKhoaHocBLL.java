
package BLL;

import BLL.KQKhoaHocDTO;
import DAL.KQKhoaHocDAL;
import java.util.ArrayList;


public class KQKhoaHocBLL {
    KQKhoaHocDAL kqkh = new KQKhoaHocDAL();
    public static ArrayList<KQKhoaHocDTO> getData() {
        return KQKhoaHocDAL.table_nv();
    }
    
    
     public static ArrayList<HocSinhDTO> getDataCBBHS() {
        return KQKhoaHocDAL.table_cbbHS();
    }
      public static ArrayList<KhoaHocDTO> getDataCBBKH() {
        return KQKhoaHocDAL.table_cbbKH();
    }
      
      public void addCustomer(KQKhoaHocDTO kqkhDTO) {
            kqkh.addKQKH(kqkhDTO);
            
    }
      public void deleteKQKH(KQKhoaHocDTO kqkhDTO){
          kqkh.deleteKQKH(kqkhDTO);
      }
        public void editCustomer(KQKhoaHocDTO kqkhDTO) {
            kqkh.editKQKH(kqkhDTO);
    }
}
