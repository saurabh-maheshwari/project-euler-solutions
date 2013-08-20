/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.heliosmi.euler.worksheet;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;

import com.heliosmi.euler.problem.MainService;

/*
 * If we list all the natural numbers below 10 that are multiples of 3 or 5,
 * we get 3, 5, 6 and 9. The sum of these multiples is 23. 
 * 
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
@ContextConfiguration(locations = { "classpath:/META-INF/spring/app-context.xml"} )
@RunWith(SpringJUnit4ClassRunner.class)
public class One {
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private MainService mainService;
	
	@Test
	public void checkInitialCondition(){
		List<Integer> multiplesOf3 = mainService.getMultiplesBelowThreshold(3, 10);
		List<Integer> multiplesOf5 = mainService.getMultiplesBelowThreshold(5, 10);
		
		List<Integer> listOfAllMultiples = multiplesOf3;
		listOfAllMultiples.addAll(multiplesOf5);
		
		//Get rid of duplicates.
		Set<Integer> setOfMultiples = new HashSet<>(listOfAllMultiples);
		
		long sum = 0;
		for (Integer i:setOfMultiples){
			sum = sum + i;
		}
		assertEquals(23, sum);
	}
	
	
	@Test
	public void assertInitialCondition(){
		//get multiples of 3 below 1000
		//get multiples of 5 below 1000
		//subtract one list from another to remove duplicates
		//add the elements
		List<Integer> multipleOf3 = mainService.getMultiplesBelowThreshold(3,1000);
		List<Integer> multipleOf5 = mainService.getMultiplesBelowThreshold(5, 1000);
		
		List<Integer> listOfAllMultiples = multipleOf3;
		listOfAllMultiples.addAll(multipleOf5);
		
		//Get rid of duplicates
		Set<Integer> setOfMultiples = new HashSet<>(listOfAllMultiples);
		
		long sum =0;
		for (Integer i:setOfMultiples){
			sum = sum + i;
		}
		
		log.info("Result for problem 1: " + sum);

		//Taken from google
		assertEquals(233168, sum);
	}
	
	
	
}
