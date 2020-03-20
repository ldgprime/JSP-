<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>


    <!-- START carousel -->
    <section class="home-slider owl-carousel">

      <div class="slider-item" style="background-image: url(images/bg_3.jpg);" data-stellar-background-ratio="0.5">
      	<div class="overlay"></div>
        <div class="container">
          <div class="row slider-text justify-content-center align-items-center">

            <div class="col-md-7 col-sm-12 text-center ftco-animate">
            	<h1 class="mb-3 mt-5 bread">구매후기</h1>	            
            </div>

          </div>
        </div>
      </div>
    </section>
    <!-- END carousel -->

    <!-- STRAT board-single -->
   <section class="ftco-section py-5">
      <div class="container">
        <div class="row">          
            <div class="col-md-12 ftco-animate">              
                <table class="table">
                  <thead class="thead-primary">
                    <tr>
                      <th>글번호</th>                     
                      <th>제목</th>
                      <th>아이디</th>
                      <th>작성시간</th>
                    </tr>
                  </thead>
                  <tbody>
                    
                    <tr style="border-bottom: none;">
                      <td>${buVM.board.id }</td>                                         
                      <td>${buVM.board.title }</td>
                      <td>${buVM.user.username }</td>
                      <td>${buVM.board.createtime }</td>                   
                    </tr>
                      <td colspan="4">
                      <div class="text-left">
                        ${buVM.board.content }
                      </div>
                      </td>
                  </tbody>
                </table>
             </div>
         </div>
         <a href="/coffee/board?cmd=list" class="btn btn-primary mx-2" style="float:right">목록</a>
         <c:if test="${sessionScope.user.id eq buVM.board.userid }" >
         <button id="delete" type="button" class="btn btn-danger mx-2" style="float:right">삭제</button>
         <a href="/coffee/board?cmd=update&id=${buVM.board.id }&userid=${buVM.board.userid}" class="btn btn-warning mx-2" style="float:right">수정</a>  
         </c:if>     
        </div>    
        
        
        <form id ="deleteForm" action="/coffee/board?cmd=delete" method="POST">	
	    <input type="hidden" name="id" value="${buVM.board.id }" /> 
	    <input type="hidden" name="userid" value="${buVM.board.userid }" />
	    </form>
	 
	
	
	


    </section> 
    <!-- END section -->

    <!-- START comments -->
     <section class="ftco-section py-0">
          <div class="container">
            <h3>댓글</h3>
         
            <div id="commentlist">
            </div>
            
           
            <!-- END comment-list -->
            
            <c:choose>
            <c:when test="${not empty sessionScope.user.id }">
            <div class="comment-form-wrap pt-5">
              <h3 class="mb-5">댓글달기</h3>
              <form action="#">
                <div class="form-group">
                  <label for="message">Message</label>
                  <textarea  id="content" cols="30" rows="5" class="form-control" placeholder="댓글을 작성해주세요."></textarea>
                </div>
                <div class="form-group">
                  <input onclick="postcomment()" type="button" value="댓글달기" class="btn py-3 px-4 btn-primary">
                </div>
              </form>
            </div>
            </c:when>
            <c:otherwise>
             <h3 class="mb-5">댓글을 다시려면 로그인이 필요합니다.</h3>
            </c:otherwise>
            </c:choose>
           
          </div>    

      </section> 
    <!-- END comments -->



<%@ include file="../include/footer.jsp"%>



<script>		
	$('#delete').on('click', function() {	
		$('#deleteForm').submit();
	
    }) 

    var objCommentList = document.querySelector('#commentlist');
    
    
    function showComments(array) {
		var ucVMs =  new Array();
	        ucVMs  = JSON.parse(array)
    		let str = '';
    		for (let ucVM of ucVMs) {
    			//str += comment.bnum + ', ' + comment.cnum + ', ' + comment.name + ', ' + comment.content + ', ' + comment.regDate + '<br>';
    			str +=" <ul class='comment-list'> ";
    			str += " <li class='comment'> ";
    		    str += " <div class='comment-body'> ";
    			str += " <h3>"+ ucVM.user.username +" </h3> ";
    			str += " <div class='meta'>"+ucVM.comment.createtime+"</div> " ;            
    			str += " <p>"+ucVM.comment.content +"</p> "     			
    			str += " <button onclick='deletecomment("+ucVM.comment.id+")' type='button' class='reply' style='float:right'>삭제</button> " 
    		    str += " </div> "         
    		    str += " </li> "        		    
    		    str += " </ul> "       		    	    		    
    		    	
    		}    		
    		objCommentList.innerHTML = str;
    	} // showComments
    
    
    function getCommentList() {
    		$.ajax({
    			url:'/coffee/board?cmd=selectcomment',
    			dataType:"text",
    			contentType:"application/x-www-form-urlencoded",	    			
    			data: "boardid="+${buVM.board.id },
    			success: function (str) {
    				console.log(str);
    				showComments(str);
    			}
    		});
    	}//getCommentList

    	   getCommentList();
    
    function postcomment(){
        var boardid = ${buVM.board.id };
        <%
        boolean s_level = false;       
        if(request.getSession().getAttribute("user")!= null){
        	s_level = true;        
        }
        if(s_level){
        %>    
        var userid = ${sessionScope.user.id };
        <%
        }
        %> 
    	var content = $("#content").val();		
		if(content === "" || content === null){					
			alert('내용이 입력되지 않았습니다.')
			return
	     }
		
	    var comment = {
		content:content,
		boardid:boardid,
		userid:userid
		}    
	 

	    
		   $.ajax({
			type:"POST",
			url:"/coffee/board?cmd=postcomment",
			dataType:"text",
			contentType:"application/json",	
			data:JSON.stringify(comment),
		
			success:function(data){
				if(data === "ok"){	
					getCommentList();
				}else{				
				}			
			},
			error:function(data){
				alert("통신실패");					
			},										
		});		
		var num;

	
	}

    function deletecomment(num){
    	$.ajax({
			url:'/coffee/board?cmd=deletecomment',
			dataType:"text",
			contentType:"application/x-www-form-urlencoded",	    			
			data: "id="+num,
			success: function (data) {
				if(data === "ok") {
					 getCommentList();
				} 
			}
		});
	    
	}
    
 
    
    
    
    
    
		
</script>