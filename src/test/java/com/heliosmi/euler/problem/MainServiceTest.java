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
package com.heliosmi.euler.problem;

import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainServiceTest {

	private Logger log = LoggerFactory.getLogger(getClass());

	private MainService mainService = new MainService();

	@Test
	public void testGetMultiplesBelowThreshold() {
		List<Integer> result = mainService.getMultiplesBelowThreshold(2, 10);
		Integer[] expectedArray = { 2, 4, 6, 8 };
		assertArrayEquals(result.toArray(), expectedArray);
	}

}
