package com.cibertec.assessment.service.imp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.assessment.beans.PolygonBean;
import com.cibertec.assessment.model.Polygon;
import com.cibertec.assessment.repo.PolygonRepo;
import com.cibertec.assessment.service.PolygonService;

@Service
public class PolygonServiceImpl implements PolygonService {

	@Autowired
	PolygonRepo polygonRepo;

	@Override
	public void create(Polygon p) {
		polygonRepo.save(p);
	}

	@Override
	public void create(List<Polygon> lp) {
		polygonRepo.saveAll(lp);
	}

	@Override
    public List<PolygonBean> list() {
        List<Polygon> list = polygonRepo.findAll();
        return list.stream().map(this::convertToPolygonBean).collect(Collectors.toList());
    }

    private PolygonBean convertToPolygonBean(Polygon p) {
        PolygonBean polygonBean = new PolygonBean();
        polygonBean.setId(p.getId());
        polygonBean.setName(p.getName());
        polygonBean.setXPoints(p.getXPoints());
        polygonBean.setYPoints(p.getYPoints());
        polygonBean.setNpoints(p.getNpoints());
        return polygonBean;
    }

}
