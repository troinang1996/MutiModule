package ImplService;

import IDao.IProductDAO;
import IService.ICookieService;
import IService.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImplProductService<L,K> extends GeneralService<L,K> implements IProductService<L,K> {
    @Autowired
    private IProductDAO dao;
    @Autowired
    private ICookieService cookieService;

    @Override
    public List<L> findByKeywords(String keyWords) {
        return dao.findByKeywords(keyWords);
    }

    @Override
    public List<L> findAllProductByCategory(int id) {
        return dao.findByCategoryId(id);
    }

    @Override
    public List<L> findByHot(String key) {
        return dao.findItemByHot(key);
    }

    @Override
    public List<L> getViewProduct(String name, String id) {
        String ids = cookieService.getCookieValue(name, id.toString());
        if (!ids.contains(id.toString())) {
            ids += "," + id.toString();
        }
        cookieService.createCookie(name, ids, 15);
        return dao.findByIdsInCookie(ids);
    }

    @Override
    public List<L> getFaVoProduct(String name, String id) {
        String favos = cookieService.getCookieValue(name, "");
        if (favos.length() > 0)
        {
            return dao.findByIdsInCookie(favos);
        } else
            return null;
    }

    @Override
    public List<L> findByIdsInCookie(String ids) {
        return dao.findByIdsInCookie(ids);
    }
}
