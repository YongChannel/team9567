<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="../includes/header.jsp"%>
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                		<h2 class="page-header"> 품목 정보 등록</h2>
                    </div>
                </div>
                <!-- /.row -->
                
                <div class="row">
                	<div class="col-lg-12">
						<form action="/part/register" method="post" enctype="multipart/form-data">
							<div class="col-lg-2" style="float:right">
								<button type="submit" class="btn btn-success">등록</button>
								<button type="button" class="btn btn-warning" style="float:right" onclick="deleteValue();">삭제</button>
							</div><br><br>
							
							<div class="table-responsive" style="width:100%">
		                        <table class="table table-bordered table-hover table-striped">
		                        	<tbody>
		                                <tr>
		                                    <th class="text-center" style="width:10%">품목명</th>
		                                    <td style="width:15%"><input type="text" class="form-control input-sm" name="PartName" ></td>
		                                    
		                                    <th class="text-center" style="width:10%">약칭</th>
		                                    <td style="width:15%"><input type="text" class="form-control input-sm" name="NickName"></td>
		                                    
		                                    <th class="text-center" style="width:10%">대분류</th>
		                                    <td style="width:15%"><select id="Select1" class="form-control input-sm" name="Library" onchange="categoryChange(this)">
		                                    		<option>선택해주세요.</option>
		                            				<option value="A">장착부</option>
		                            				<option value="B">정렬부</option>
		                            				<option value="C">제어부</option>
		                            				<option value="D">주입부</option>
		                            				<option value="E">취출부</option>
		                            				<option value="F">투입부</option>
		                        				</select></td>
		                        				
		                        			<th class="text-center" style="width:10%">중분류</th>
		                                    <td style="width:15%"><select id="Select2" class="form-control input-sm" name="Librarym">
	                                    			<option>선택해주세요.</option>
		                        				</select></td>
		                        				
		                                </tr>
		                                
										<tr>
											<th class="text-center" style="width:10%">품목설명</th>
		                                    <td style="width:15%"><input type="text" class="form-control input-sm" name="Remark"></td>
											
											<th class="text-center" style="width:10%">공용여부</th>
		                                    <td style="width:15%"><select id="Select3" class="form-control input-sm" name="Common">
		                                    		<option>선택해주세요.</option>
		                            				<option value="0">공용</option>
		                            				<option value="1">전용</option>
		                        				</select></td>
		                                    
		                                    <th class="text-center" style="width:10%">도면 IMG</th>
		                                    <td style="width:15%"><input type="file" name="Drw_Img" multiple></td>
		                                    
		                                    <td colspan="2"></td>
		                                    
		                                </tr>
		                            </tbody>
		                        </table>
		                    </div>
		                    <!-- /.table-responsive -->
						</form>
					</div>
				</div>
                <!-- /.row -->
               
                <div class="row">
                    <div class="col-lg-12">
                        <h3 class="page-header">품목 정보 리스트</h3>
                    </div>
                </div>
                <!-- /.row -->
                
                <div class="row">
                	<div class="col-lg-6">
                		<form action="/part/partList" method="get">
	                    	<div class="col-lg-2">
		                    	<div class="form-group">
		                    		<select id="Select4" class="form-control input-sm" name="type">
			                            <option ${pageMaker.cri.type == "C"? "selected" : ""} value="C">품목코드</option>
			                            <option ${pageMaker.cri.type == "W"? "selected" : ""} value="W">품목명</option>
		                        	</select>
		                   		</div>
	                   		</div>
	                   		
	                   		<div class="col-lg-4">
	                   			<div class="form-group">
									<input type="text" class="form-control input-sm" name="keyword" value="${pageMaker.cri.keyword}">
								</div>
							</div>
	                   		<button class="btn btn-default btn-sm" type="submit"><i class="fa fa-search"></i></button>
	                   	</form>
                   	</div>
                </div>
                <!-- /.row -->
                
                <div class="row">
	                <div class="col-lg-12">
	                    <div class="table-responsive">
	                        <table class="table table-striped table-bordered table-hover" id="dataTables-example">
	                        	<thead>
	                                <tr>
	                                	<th class="text-center" style="width:5%"><input type="checkbox" name="checkAll" id="checkAll"></th>
	                                	<th class="text-center" style="width:10%">품목코드</th>
	                                    <th class="text-center" style="width:10%">품목명</th>
	                                    <th class="text-center" style="width:10%">약칭</th>
	                                    <th class="text-center" style="width:10%">대분류</th>
	                                    <th class="text-center" style="width:10%">중분류</th>
	                                    <th class="text-center" style="width:15%">품목설명</th>
	                                    <th class="text-center" style="width:10%">공용여부</th>
	                                    <th class="text-center" style="width:15%">도면 IMG</th>
	                                </tr>
	                            </thead>
	                            
	                            <tbody>
		                            <c:forEach var="part" items="${list}">
		                                <tr class="select_subject">
		                                	<td class="text-center"><input type="checkbox" name="checkRow" value="${part.partCode}"></td>
		                                	
		                                	<td>${part.partCode}</td>
		                                	
		                                    <td><a href="/part/getList?partCode=${part.partCode}&pageNum=${pageMaker.cri.pageNum}&amount=${pageMaker.cri.amount}&type=${pageMaker.cri.type}&keyword=${pageMaker.cri.keyword}">${part.partName}</a></td>
		                                    
		                                    <td>${part.nickName}</td>
		                                  	
		                                    <td><c:if test="${part.library == 'A'}">
		                                    		장착부
		                                    	</c:if>
		                                    	<c:if test="${part.library == 'B'}">
		                                    		정렬부
		                                    	</c:if>
		                                    	<c:if test="${part.library == 'C'}">
		                                    		제어부
		                                    	</c:if>                                    	
		                                    	<c:if test="${part.library == 'D'}">
		                                    		주입부
		                                    	</c:if>                                    	
		                                    	<c:if test="${part.library == 'E'}">
		                                    		취출부
		                                    	</c:if>                                    	
		                                    	<c:if test="${part.library == 'F'}">
		                                    		투입부
		                                    	</c:if></td>
		                                    
		                                    <td><c:if test="${part.library == 'A' and part.librarym == 'A'}">
		                                    		감지기
		                                    	</c:if>
		                                    	<c:if test="${part.library == 'A' and part.librarym == 'B'}">
		                                    		고정대
		                                    	</c:if>
		                                    	
		                                    	<c:if test="${part.library == 'B' and part.librarym == 'A'}">
		                                    		투영기
		                                    	</c:if>
		                                    	
		                                 		<c:if test="${part.library == 'C' and part.librarym == 'A'}">
		                                    		제어판 이슈
		                                    	</c:if>
		                                    	
		                                    	<c:if test="${part.library == 'D' and part.librarym == 'A'}">
		                                    		여과장치
		                                    	</c:if>
		                                    	
		                                    	<c:if test="${part.library == 'E' and part.librarym == 'A'}">
		                                    		이동 컨베이어
		                                    	</c:if>
		                                    	
		                                    	<c:if test="${part.library == 'F' and part.librarym == 'A'}">
		                                    		구동축
		                                    	</c:if>
		                                    	<c:if test="${part.library == 'F' and part.librarym == 'B'}">
		                                    		커넥터
		                                    	</c:if></td>
		                                    	
											<td>${part.remark}</td>
		                                    
		                                    <td><c:if test="${part.common == 0}">
		                                    		공용
		                                    	</c:if>
		                                   		<c:if test="${part.common == 1}">
		                                    		전용
		                                    	</c:if></td>
		                                    
		                                    <td><a href="/download?uploadPath=${fn:replace(part.uploadPath, '\\', '-')}&uuid=${part.uuid}&fileName=${part.fileName}">${part.fileName}</a></td>
		                                </tr>
		                            </c:forEach>
	                         	</tbody>
							</table>
						</div>
						<!-- /.table-responsive -->
					</div>
				</div>
				<!-- /.row -->
				
				<div class="text-center">
					<ul class="pagination justify-content-center">
						<c:if test="${pageMaker.prev}">
							<li class="page-item"><a class="page-link" href="/part/partList?pageNum=${pageMaker.startPage-1}&amount=${pageMaker.cri.amount}&type=${pageMaker.cri.type}&keyword=${pageMaker.cri.keyword}"> << </a></li>
						</c:if>
						
						<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="num">
							<li class="page-item">
								<a class="page-link" href="/part/partList?pageNum=${num}&amount=${pageMaker.cri.amount}&type=${pageMaker.cri.type}&keyword=${pageMaker.cri.keyword}">
									<c:if test="${pageMaker.cri.pageNum == num}">
										<b>${num}</b>
									</c:if>
									
									<c:if test="${pageMaker.cri.pageNum != num}">
										${num}
									</c:if>
								</a>
							</li>
						</c:forEach>
						
						<c:if test="${pageMaker.next}">
							<li class="page-item"><a href="/part/partList?pageNum=${pageMaker.endPage+1}&amount=${pageMaker.cri.amount}&type=${pageMaker.cri.type}&keyword=${pageMaker.cri.keyword}"> >> </a></li>
						</c:if>
					</ul>
				</div>
				
			</div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->
    </div>
    <!-- /#wrapper -->
	
	
	<!-- 보전관련 설비명 유형-->
	<script>
		function categoryChange(e) {
			var AA = ["감지기", "고정대"];
			var BB = ["투영기"];
			var CC = ["제어판 이슈"];
			var DD = ["여과장치"];
			var EE = ["이동 컨베이어"];
			var FF = ["구동축", "커넥터"];
			var target = document.getElementById("Select2");
			
			if(e.value == "A") var el = AA;
			else if(e.value == "B") var el = BB;
			else if(e.value == "C") var el = CC;
			else if(e.value == "D") var el = DD;
			else if(e.value == "E") var el = EE;
			else if(e.value == "F") var el = FF;
			
			target.options.length = 0;
			
			for (x in el) {
				var opt = document.createElement("option");
				opt.value = (x == 0) ? "A" : "B";
				opt.innerHTML = el[x];
				target.appendChild(opt);
				
			}
		}
	</script>
	
	
	<!-- 선택 품목 삭제 -->
	<script type="text/javascript">
		$(function() {
			var chkObj = document.getElementsByName("checkRow");
			var rowCnt = chkObj.length;
			
			$("input[name='checkAll']").click(function() {
				var chk_listArr = $("input[name='checkRow']");
				for(var i = 0; i < chk_listArr.length; i++) {
					chk_listArr[i].checked = this.checked;
				}
			});
			
			$("input[name='checkRow']").click(function() {
				if($("input[name='checkRow']:checked").length == rowCnt) {
					$("input[name='checkAll']")[0].checked = true;
				} else {
					$("input[name='checkAll']")[0].checked = false;
				}
			});
		});
		
		function deleteValue() {
			var url = "/part/remove";
			var valueArr = new Array();
			var list = $("input[name='checkRow']");
			
			for(var i = 0; i < list.length; i++) {
				if(list[i].checked) {
					valueArr.push(list[i].value);
				}
			}
			
			if(valueArr.length == 0) {
				
			} else {
				$.ajax({
					url: url,
					type: 'POST',
					traditional: true,
					data: {
						valueArr: valueArr
					},
					success: function() {
						location.replace("/part/partList?pageNum=${pageMaker.cri.pageNum}&amount=${pageMaker.cri.amount}&type=${pageMaker.cri.type}&keyword=${pageMaker.cri.keyword}");
					}
				});
			}
		}
	</script>
	
	<!-- 전체 품목 체크 -->
	<script>
		function checkAll() {
			if($("#checkAll").is(':checked')) {
				$("input[name=checkRow]").prop("checked", true);
			} else {
				$("input[name=checkRow]").prop("checked", false);
			}
		}
	</script>
	
	<!-- jQuery -->
    <script src="/resources/vendor/jquery/jquery.min.js"></script>
	
    <!-- Bootstrap Core JavaScript -->
    <script src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script>
	
    <!-- Metis Menu Plugin JavaScript -->
    <script src="/resources/vendor/metisMenu/metisMenu.min.js"></script>
	
    <!-- Custom Theme JavaScript -->
    <script src="/resources/dist/js/sb-admin-2.js"></script>
</body>

</html>
