package com.sy.mall.Service;

import com.sy.mall.mapper.WaresMapper;
import com.sy.mall.pojo.Wares;
import com.sy.mall.pojo.dto.WaresQueryDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 李磊
 * on 17-4-29.
 */
@Service
public class WaresService extends BaseService<Wares> {
    private static final Logger LOGGER = LoggerFactory.getLogger(WaresService.class);

    @Resource
    private WaresMapper waresMapper;

    @Resource
    public void setMapper(WaresMapper waresMapper) {
        super.setMapper(waresMapper);
    }

    public List<Wares> listWares(WaresQueryDTO waresQueryDTO) {
        return waresMapper.listWares(waresQueryDTO);
    }

    public Wares getWares(Integer waresId) {
        WaresQueryDTO waresQueryDTO = new WaresQueryDTO();
        waresQueryDTO.setWaresId(waresId);
        List<Wares> wares = listWares(waresQueryDTO);
        if(wares.size()>0){
            return wares.get(0);
        }
        return null;
    }
}
