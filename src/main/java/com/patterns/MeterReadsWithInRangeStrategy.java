package com.patterns;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;



public class MeterReadsWithInRangeStrategy extends FindFetchStrategy {

//	@Override
//	boolean isApplicable(MeterReadsContext context) {
//		return (context.getVersionTime()==null && context.getNumVersions()==null);
//	}
//
//	@Override
//	void getMeterReadsForContext(MeterReadsResponse meterReadsResponse, MeterReadsContext context,
//			MeteredSvcPt meteredSvcPt, List<Channel> channelList) {
//		
//		 Date startTime = ApiDateTimeUtils.toDate(context.getStartTimeZdt());
//		    Date endTime = ApiDateTimeUtils.toDate(context.getEndTimeZdt());
//		    
//			 for(Channel chnl:channelList) {
//				 MeasType measType = MeteredSvcPtLookupUtil.getMeasurement(eidg, chnl.getMeasTypeId());
//		         if (measType != null && measType.getEtype().equalsIgnoreCase(MeterDataConstants.MEAS_TYPE_ETYPE_INTERVAL)) {
//		        	 ReadsResponse intvlResponse = getIntervalResponseForChannel(chnl, meteredSvcPt, startTime, endTime,context.getStartTimeZdt().getZone());
//		        	 
//		        	 if(!CollectionUtils.isEmpty(intvlResponse.getReadings())) {
//		        	   meterReadsResponse.getLpIntervals().add(intvlResponse);
//		        	 }
//		        	 
//				}else if(measType != null && measType.getEtype().equalsIgnoreCase(MeterDataConstants.MEAS_TYPE_ETYPE_CUMULATIVE)) {
//					ReadsResponse registerResponse = getRegisterResponseForChannel(chnl, meteredSvcPt, startTime, endTime,context.getStartTimeZdt().getZone());
//
//		            if(!CollectionUtils.isEmpty(registerResponse.getReadings())) {
//		              meterReadsResponse.getRegisterReads().add(registerResponse);
//		            }
//				}     	
//		     }
//		
//	}
//	
//	
//	  public ReadsResponse getIntervalResponseForChannel(Channel chnl, MeteredSvcPt meteredSvcPt,Date startTime, Date endTime,ZoneId zoneId) {
//		  	List<Reading> intvlReading = lpIntervalDataStore.fetchReadsForChannel(chnl.getId(), startTime, endTime);
//	     	return getReadResponse(chnl, intvlReading, zoneId);
//	 }
//
//	  public ReadsResponse getRegisterResponseForChannel(Channel chnl, MeteredSvcPt meteredSvcPt,Date startTime, Date endTime,ZoneId zoneId) {
//	  		List<Reading> registerReading = iRegisterReadDataStore.fetchReadsForChannel(chnl.getId(), startTime, endTime);  	
//	  		return getReadResponse(chnl, registerReading, zoneId);
//	  }

}
