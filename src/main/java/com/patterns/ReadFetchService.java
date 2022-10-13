package com.patterns;
import java.util.ArrayList;
import java.util.List;



public class ReadFetchService {
//    private List<FindFetchStrategy> fetchStrategies = new ArrayList<>();
//    
//    ReadFetchService(List<FindFetchStrategy> fetchStrategies){
//    	this.fetchStrategies.addAll(fetchStrategies);
//    }
//
//    
//    public void getMeterReads(MeterReadsResponse meterReadsResponse,
//    		MeterReadsContext context,MeteredSvcPt meteredSvcPt,List<Channel> channelList) {
//    	for(FindFetchStrategy strategy:fetchStrategies) {
//    		if(strategy.isApplicable(context)) {
//    			strategy.getMeterReadsForContext(meterReadsResponse, context, meteredSvcPt, channelList);
//    		}
//    	}
//    }
//
//	public List<FindFetchStrategy> getFetchStrategies() {
//		return fetchStrategies;
//	}
//
//
//	public void setFetchStrategies(List<FindFetchStrategy> fetchStrategies) {
//		this.fetchStrategies = fetchStrategies;
//	}
//    
    
    /*Bean intialization 
     * <bean id="meterReadsRequestProcessor" class="com.emeter.api.meterreads.processor.MeterReadsRequestProcessor">
		<property name="validators" ref="meterReadsApiValidators"></property>
		<property name="fetchService" ref="readFetchService"></property>	
		</bean>
     * 	
     <bean id="fetchStrategy" class="java.util.LinkedList">
			<constructor-arg>
				<list>
					<ref bean="meterReadfetchDateRangeStrategy" />
					<ref bean="meterReadfetchForVersionStrategy" />
				</list>
			</constructor-arg>	
	</bean>
	
	<bean id="meterReadfetchDateRangeStrategy" class="com.emeter.api.meterreads.strategy.MeterReadsAsOfVersionWithinRangeStratagy" />
	
	<bean id="meterReadfetchForVersionStrategy" class="com.emeter.api.meterreads.strategy.MeterReadsWithInRangeStrategy" />
     */
}
