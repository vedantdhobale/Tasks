package com.blog.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entities.Comment;
import com.blog.entities.Post;
import com.blog.exception.ResourceNotFoundException;
import com.blog.payload.CommentDto;
import com.blog.repository.CommentRepo;
import com.blog.repository.PostRepo;
import com.blog.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	
	

	@Override
	public CommentDto createComment(CommentDto commentDto,Integer postId) {
		
		
		Post post=this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("post","post id",postId));
		
		Comment comment = this.modelMapper.map(commentDto, Comment.class);
		
		comment.setPost(post);
		
		Comment savedComent= this.commentRepo.save(comment);
		
		return this.modelMapper.map(savedComent, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		
		
		Comment com = this.commentRepo.findById(commentId).orElseThrow(()->new ResourceNotFoundException("comment","comment id",commentId));
		
		
		 this.commentRepo.delete(com);
	}

}
