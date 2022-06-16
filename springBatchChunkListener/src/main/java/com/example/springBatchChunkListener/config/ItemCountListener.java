package com.example.springBatchChunkListener.config;

import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.scope.context.ChunkContext;

public class ItemCountListener implements ChunkListener{

	@Override
	public void beforeChunk(ChunkContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterChunk(ChunkContext context) {
		int count = context.getStepContext().getStepExecution().getReadCount();
	    System.out.println("ItemCount: " + count);
		
	}

	@Override
	public void afterChunkError(ChunkContext context) {
		// TODO Auto-generated method stub
		
	}

}
