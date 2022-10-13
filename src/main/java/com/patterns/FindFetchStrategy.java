package com.patterns;
import java.time.ZoneId;
import java.util.List;


public abstract class FindFetchStrategy {
//	@Autowired
//	protected EipDataGrid eidg;
//	@Autowired
//	protected ILpIntervalDataStore lpIntervalDataStore;
//	@Autowired
//	protected IRegisterReadDataStore iRegisterReadDataStore;
//	
//	public ReadsResponse getReadResponse(Channel ch, List<Reading> readingList, ZoneId zoneId) {
//	    
//	    ReadsResponse readResponse = new ReadsResponse(ch.getId(), ch.getMeasTypeId());
//
//	    if(!CollectionUtils.isEmpty(readingList)) {
//	      for(Reading r : readingList) {
//	        
//	        if(readResponse.getDeviceId() == null) {
//	          readResponse.setDeviceId(r.getDeviceId());
//	        }           
//	          readResponse.getReadings().add(ConvertReadingToApiResponse.converReadingsToResponse(r, zoneId));
//	      }
//	    }
//	    return readResponse;
//	}
//	
//	abstract boolean isApplicable(MeterReadsContext context);
//	abstract void getMeterReadsForContext(MeterReadsResponse meterReadsResponse, MeterReadsContext context,
//			MeteredSvcPt meteredSvcPt,List<Channel> channelList);
}
