<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>

		<div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                		<h2 class="page-header"> 회사 정보 수정</h2>
                    </div>
                </div>
                <!-- /.row -->
                
                <div class="row">
                	<div class="col-lg-12">
						<form action="/company/modify" method="post">
							<div class="col-lg-2" style="float:right">
								<button type="submit" class="btn btn-info">수정</button>
								<button type="button" class="btn btn-warning" style="float:right" 
									onclick="location.href='/company/companyList?pageNum=${criteria.pageNum}&amount=${criteria.amount}&type=${pageMaker.cri.type}&keyword=${pageMaker.cri.keyword}'">취소</button>
							</div><br><br>
							
							<input type="hidden" name="Code" value="${get.code}">
							<input type="hidden" value="${criteria.pageNum}" name="pageNum">
							<input type="hidden" value="${criteria.amount}" name="amount">
							<input type="hidden" value="${criteria.type}" name="type">
							<input type="hidden" value="${criteria.keyword}" name="keyword">
							
							<div class="table-responsive" style="width:100%">
		                        <table class="table table-bordered table-hover table-striped">
		                        	<tbody>
		                                <tr>
		                                	<th class="text-center" style="width:7%">업체명</th>
		                                	<td><input type="text" class="form-control input-sm" name="Name" value="${get.name}"></td>
		                                	
		                                    <th class="text-center" style="width:7%">사업자번호</th>
		                                    <td><input type="text" class="form-control input-sm" name="Business_Number" value="${get.business_Number}"></td>
		                                    
		                                    <th class="text-center" style="width:7%">세무코드</th>
		                                    <td><input type="text" class="form-control input-sm" name="Taxcode" value="${get.taxcode}"></td>

		                                    <th class="text-center" style="width:7%">대표자</th>
		                                    <td><input type="text" class="form-control input-sm" name="Owner" value="${get.owner}"></td>
		                                    
		                                    <th class="text-center" style="width:7%">연락처</th>
		                                    <td><input type="text" class="form-control input-sm" name="Contact" value="${get.contact}"></td>
		                                    
		                                    <th class="text-center" style="width:7%">회사정보</th>
		                                    <td><input type="text" class="form-control input-sm" name="Address" value="${get.address}"></td>
										</tr>
		                                
		                                <tr>
		                                	<th class="text-center" style="width:7%">계좌정보</th>
		                                    <td><input type="text" class="form-control input-sm" name="Account" value="${get.account}"></td>
		                                	
		                                	<th class="text-center" style="width:7%">업체규모</th>
		                                	<td><select id="Select1" class="form-control input-sm" name="Company_Size">
		                                			<option>선택해주세요.</option>
		                            				<option value="대기업" <c:if test="${get.company_Size == '대기업'}"> selected</c:if>>대기업</option>
		                            				<option value="중소기업" <c:if test="${get.company_Size == '중소기업'}"> selected</c:if>>중소기업</option>
		                        				</select></td>
		                                	
											<th class="text-center" style="width:7%">업태분류</th>
		                                	<td><select id="Select2" class="form-control input-sm" name="Category">
		                                			<option>선택해주세요.</option>
		                            				<option value="도매" <c:if test="${get.category == '도매'}"> selected</c:if>>도매</option>
		                            				<option value="소매" <c:if test="${get.category == '소매'}"> selected</c:if>>소매</option>
		                        				</select></td>
		                                	
		                                	<th class="text-center" style="width:7%">매출액</th>
		                                    <td><input type="text" class="form-control input-sm" name="Sales" value="${get.sales}"></td>
		                                	
		                                	<th class="text-center" style="width:7%">거래형태</th>
		                                    <td><input type="text" class="form-control input-sm" name="Deal_Type" value="${get.deal_Type}"></td>
		                                	
		                                	<th class="text-center" style="width:7%">내외자구분</th>
		                                	<td><select id="Select3" class="form-control input-sm" name="Domestic_Foreign">
		                                			<option>선택해주세요.</option>
		                            				<option value="국내" <c:if test="${get.domestic_Foreign == '국내'}"> selected</c:if>>국내</option>
		                            				<option value="해외" <c:if test="${get.domestic_Foreign == '해외'}"> selected</c:if>>해외</option>
		                        				</select></td>
		                        		</tr>
		                        		
		                        		<tr>
		                                	<th class="text-center" style="width:7%">결제통화</th>
		                                	<td><select id="Select4" class="form-control input-sm" name="Currency">
		                                			<option>선택해주세요.</option>
		                            				<option value="usd" <c:if test="${get.currency == 'usd'}"> selected</c:if>>usd</option>
		                            				<option value="krw" <c:if test="${get.currency == 'krw'}"> selected</c:if>>krw</option>
		                        				</select></td>
		                                	
		                                	<th class="text-center" style="width:7%">거래개시일</th>
		                        			<td><input type="date" class="form-control input-sm" name="Start_Date" value='<fmt:formatDate pattern="yyyy-MM-dd" value="${get.start_Date}" />' /></td>
		                        			
											<th class="text-center" style="width:7%">거래종료일</th>
											<td><input type="date" class="form-control input-sm" name="End_Date" value='<fmt:formatDate pattern="yyyy-MM-dd" value="${get.end_Date}" />' /></td>	
		                                	
		                                	<th class="text-center" style="width:7%">계산서발행</th>
		                                	<td><select id="Select5" class="form-control input-sm" name="Invoice_Issue">
		                                			<option>선택해주세요.</option>
		                            				<option value="발행" <c:if test="${get.invoice_Issue == '발행'}"> selected</c:if>>발행</option>
		                            				<option value="미발행" <c:if test="${get.invoice_Issue == '미발행'}"> selected</c:if>>미발행</option>
		                        				</select></td>
		                                	
		                                    <th class="text-center" style="width:7%">담당자</th>
		                                    <td><input type="text" class="form-control input-sm" name="Comemployee" value="${get.comemployee}"></td>
											
											<th class="text-center" style="width:7%">이메일</th>
		                                    <td><input type="text" class="form-control input-sm" name="Comemail" value="${get.comemail}"></td>
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
                        <h3 class="page-header">회사 정보 리스트</h3>
                    </div>
                </div>
                <!-- /.row -->
                
                <div class="row">
                	<div class="col-lg-6">
                		<form action="/company/companyList" method="get">
	                    	<div class="col-lg-2">
		                    	<div class="form-group">
		                    		<select id="Select" class="form-control input-sm" name="type">
			                            <option ${pageMaker.cri.type == "C"? "selected" : ""} value="C">업체코드</option>
			                            <option ${pageMaker.cri.type == "W"? "selected" : ""} value="W">업체명</option>
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
	                                	<th class="text-center" style="width:5%">업체<br>코드</th>
	                                    <th class="text-center" style="width:5%">업체명</th>
	                                    <th class="text-center" style="width:5%">사업자<br>번호</th>
	                                    <th class="text-center" style="width:5%">세무<br>코드</th>
	                                    <th class="text-center" style="width:5%">대표자</th>
	                                    <th class="text-center" style="width:5%">연락처</th>
	                                    <th class="text-center" style="width:5%">회사<br>정보</th>
	                                    <th class="text-center" style="width:5%">계좌<br>정보</th>
	                                    <th class="text-center" style="width:5%">업체<br>규모</th>
	                                    <th class="text-center" style="width:5%">업태<br>분류</th>
	                                    <th class="text-center" style="width:5%">매출액</th>
	                                    <th class="text-center" style="width:5%">거래<br>형태</th>
	                                    <th class="text-center" style="width:5%">내외자<br>구분</th>
	                                    <th class="text-center" style="width:5%">결제<br>통화</th>
	                                    <th class="text-center" style="width:5%">거래<br>개시일</th>
	                                    <th class="text-center" style="width:5%">거래<br>종료일</th>
	                                    <th class="text-center" style="width:5%">계산서<br>발행</th>
	                                    <th class="text-center" style="width:5%">담당자</th>
	                                    <th class="text-center" style="width:5%">이메일</th>
	                                </tr>
	                            </thead>
	                            
	                            <tbody>
		                            <c:forEach var="company" items="${list}">
		                                <tr class="select_subject">
		                                	<td class="text-center"><input type="checkbox"></td>
		                                	
		                                	<td>${company.code}</td>
		                                	
		                                    <td><a href="/company/getList?code=${company.code}&pageNum=${pageMaker.cri.pageNum}&amount=${pageMaker.cri.amount}&type=${pageMaker.cri.type}&keyword=${pageMaker.cri.keyword}">${company.name}</a></td>
		                                    
		                                    <td>${company.business_Number}</td>
		                                    
		                                    <td>${company.taxcode}</td>
		                                    
		                                    <td>${company.owner}</td>
		                                    
		                                    <td>${company.contact}</td>
		                                    
		                                    <td>${company.address}</td>
		                                    
		                                    <td>${company.account}</td>
		                                    
		                                    <td>${company.company_Size}</td>
		                                    
		                                    <td>${company.category}</td>
		                                    
		                                    <td>${company.sales}</td>
		                                    
		                                    <td>${company.deal_Type}</td>
		                                    
		                                    <td>${company.domestic_Foreign}</td>
		                                    
		                                    <td>${company.currency}</td>
		                                    
		                                    <td><fmt:formatDate pattern="yyyy-MM-dd" value="${company.start_Date}" /></td>
		                                    
		                                    <td><fmt:formatDate pattern="yyyy-MM-dd" value="${company.end_Date}" /></td>
		                                    
		                                    <td>${company.invoice_Issue}</td>
		                                    
		                                    <td>${company.comemployee}</td>
		                                    
		                                    <td>${company.comemail}</td>
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
							<li class="page-item"><a class="page-link" href="/company/companyList?pageNum=${pageMaker.startPage-1}&amount=${pageMaker.cri.amount}&type=${pageMaker.cri.type}&keyword=${pageMaker.cri.keyword}"> << </a></li>
						</c:if>
						
						<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="num">	
							<li class="page-item">
								<a class="page-link" href="/company/companyList?code=${company.code}&pageNum=${num}&amount=${pageMaker.cri.amount}&type=${pageMaker.cri.type}&keyword=${pageMaker.cri.keyword}">
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
							<li class="page-item"><a href="/company/companyList?pageNum=${pageMaker.endPage+1}&amount=${pageMaker.cri.amount}&type=${pageMaker.cri.type}&keyword=${pageMaker.cri.keyword}"> >> </a></li>
						</c:if>
					</ul>
				</div>
				
			</div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->
    </div>
    <!-- /#wrapper -->
	
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
