package IService;

import java.util.List;

public interface IProductService<L, K> extends IGeneralService<L,K>{
    List<L> findByKeywords(String keyWords);
    List<L> findAllProductByCategory(int id);
    List<L> findByHot(String key);
    List<L>  getViewProduct(String name,String id); //  get những sản phẩm da xem thông qua mảng id sp trong Cookie
    List<L>  getFaVoProduct(String name,String id); // get những sản phẩm yêu thích thông qua mảng id sp trong Cookie
    List<L>  findByIdsInCookie(String ids);
}
