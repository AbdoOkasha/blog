//package c3s.blog.controller.comment;
//
//import c3s.blog.dto.commentDto.CommentDTO;
//import c3s.blog.entity.Comment;
//import c3s.blog.service.comment.CommentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("comment")
//public class CommentController {
//
//    @Autowired
//    CommentService commentService;
//
//    @PostMapping("/addComment")
//    public ResponseEntity<Object> addComment(@RequestBody Comment comment){
//        return commentService.addComment(comment);
//    }
//
//    @PutMapping("/updateComment/{commentId}")
//    public ResponseEntity<Object> updateComment(@PathVariable int commentId, @RequestBody String msg){
//        return commentService.updateComment(commentId,msg);
//    }
//
//    @DeleteMapping("/deleteComment/{commentId}")
//    public ResponseEntity<Object> deleteComment(@PathVariable int commentId){
//        return commentService.deleteComment(commentId);
//    }
//
//    @GetMapping("/getComment/{commentId}")
//    public ResponseEntity<Object> getComment(@PathVariable int commentId){
//        Comment comment = commentService.findById(commentId);
//        if(comment == null) return new ResponseEntity<>("couldn't find the comment", HttpStatus.INTERNAL_SERVER_ERROR);
//        return new ResponseEntity<>(comment, HttpStatus.ACCEPTED);
//    }
//}
