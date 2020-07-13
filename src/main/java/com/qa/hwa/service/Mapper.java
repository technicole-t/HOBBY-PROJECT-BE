package com.qa.hwa.service;

public interface Mapper<Source, Target> {
	
	Target mapToDTO(Source source);
}
