package com.patterns;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;



public class MeterReadsAsOfVersionWithinRangeStratagy extends FindFetchStrategy{
//
//	@Override
//	boolean isApplicable(MeterReadsContext context) {
//		return (context.getVersionTime() != null && context.getNumVersions() == null);
//	}
//
//	@Override
//	public void getMeterReadsForContext(MeterReadsResponse meterReadsResponse, MeterReadsContext context,
//			MeteredSvcPt meteredSvcPt, List<Channel> channelList) {
//		 	Date startTime = ApiDateTimeUtils.toDate(context.getStartTimeZdt());
//		    Date endTime = ApiDateTimeUtils.toDate(context.getEndTimeZdt());
//		    Date versionTime = ApiDateTimeUtils.toDate(context.getVersionTime());
//
//			 for(Channel chnl:channelList) {
//				 MeasType measType = MeteredSvcPtLookupUtil.getMeasurement(eidg, chnl.getMeasTypeId());
//		         if (measType != null && measType.getEtype().equalsIgnoreCase(MeterDataConstants.MEAS_TYPE_ETYPE_INTERVAL)) {
//		        	 ReadsResponse intvlResponse = getIntervalResponseVersionForChannel(chnl, meteredSvcPt, startTime, endTime,
//		        			 versionTime, context.getStartTimeZdt().getZone());
//		        	 
//		        	 if(!CollectionUtils.isEmpty(intvlResponse.getReadings())) {
//		        	   meterReadsResponse.getLpIntervals().add(intvlResponse);
//		        	 }
//		        	 
//				}else if(measType != null && measType.getEtype().equalsIgnoreCase(MeterDataConstants.MEAS_TYPE_ETYPE_CUMULATIVE)) {
//					ReadsResponse registerResponse = getRegisterResponseVersionForChannel(chnl, meteredSvcPt, startTime, endTime,
//							versionTime,context.getStartTimeZdt().getZone());
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
//	
//	
//	public ReadsResponse getIntervalResponseVersionForChannel(Channel chnl, MeteredSvcPt meteredSvcPt,Date startTime, Date endTime,
//			  Date versionTime,ZoneId zoneId) {
//		  	List<Reading> intvlReading = lpIntervalDataStore.fetchVersionOfReadsForChannel(chnl.getId(), startTime, endTime,versionTime);
//		  	return getReadResponse(chnl, intvlReading, zoneId);
//	}
//
//	public ReadsResponse getRegisterResponseVersionForChannel(Channel chnl, MeteredSvcPt meteredSvcPt,Date startTime, Date endTime,
//			Date versionTime,ZoneId zoneId) {
//			List<Reading> registerReading = iRegisterReadDataStore.fetchVersionOfReadsForChannel(chnl.getId(), startTime, endTime,versionTime);  	
//			return getReadResponse(chnl, registerReading, zoneId);
//	}

}
