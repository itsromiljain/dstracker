package com.tracker.repository.projectTracker;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.tracker.model.projectTracker.ProjTrakr;

@Repository
public class ExtendedTrackerRepoImpl implements ExtendedTrackerRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<ProjTrakr> getProjectsRepo(long id) {
//		StringBuilder sb = new StringBuilder();
//		sb.append("select proj_id,appl_mngr,clnt_apprctn,proj_desc,indctn_kit,dmngr_dtls,imt_dtls,");
//		sb.append("stats_issue,escalation,fnl_delivery,lti_mngd,");
//		sb.append("lti_ofshr_teams,lti_ofshr_team_mem,lti_onst_lead,lti_onst_teams,");
//		sb.append("nxt_mstone,nxt_mstone_ddat,mitigation,lti_ofshr_lead,other_vendors,ovral_teams, pfolio_nm,");
//		sb.append(
//				"proj_nm, remarks,shift_tim,proj_stats,wkly_stats_clnt,(Select dmngr_nm from Delvrymgr where Delvrymgr.dmngr_id= Projtrakr.dmngr_dtls) as dm_name,(Select imt_nm from Imt where Imt.imt_id= Projtrakr.imt_dtls) as imt_name from Projtrakr");
//		if (id != 0l)
//			sb.append(" where proj_id='" + id + "'");
//
//		return entityManager.createNativeQuery(sb.toString(), ProjTrakr.class).getResultList();
//	}
	 

	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ProjTrakr> getProjectsRepo(long id){
		StringBuilder sb = new StringBuilder();
		sb.append("select * from Projtrakr");
		return  entityManager.createNativeQuery(sb.toString(), ProjTrakr.class).getResultList();
		
	}


	
	
}
