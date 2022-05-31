<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

		<div class="fh5co-hero">
			<div class="fh5co-overlay"></div>
			<div class="fh5co-cover" data-stellar-background-ratio="0.5">
				<div class="desc">
					<div class="container">
						<div class="row">
							<div class="col-sm-5 col-md-5" style="margin-top: 60px;">
								<div class="tabulation animate-box">
									<div class="tab-content">
										<!-- form start -->
										<form id="flightFrm" name="flightFrm" action="/fs/searchFlight" method="post">
											 <div role="tabpanel" class="tab-pane active" id="flights">
												<div class="row">
													<div class="col-xxs-12 col-xs-6 mt">
														<section>
															<label for="from" style="margin-bottom: 10px;">출발지 (필수)</label>
															<select class="cs-select cs-skin-border" id="from_place" name="from_place">
																<option value="" disabled selected>출발지 선택</option>
						                                        <option value="NAARKJJ">광주</option>
						                                        <option value="NAARKJK">군산</option>
																<option value="NAARKSS">김포</option>
						                                        <option value="NAARKPK">김해/부산</option>
						                                        <option value="NAARKTN">대구</option>
						                                        <option value="NAARKJB">무안</option>
						                                        <option value="NAARKPS">사천</option>
						                                        <option value="NAARKNY">양양</option>
						                                        <option value="NAARKJY">여수</option>
						                                        <option value="NAARKPU">울산</option>
						                                        <option value="NAARKNW">원주</option>
						                                        <option value="NAARKSI">인천</option>
						                                        <option value="NAARKPC">제주</option>
						                                        <option value="NAARKTU">청주</option>
						                                        <option value="NAARKTH">포항</option>
															</select>
														</section>
													</div>
													<div class="col-xxs-12 col-xs-6 mt">
														<section>
															<label for="from" style="margin-bottom: 10px;">도착지 (필수)</label>
															<select class="cs-select cs-skin-border" id="to_place" name="to_place">
																<option value="" disabled selected>도착지 선택</option>
																<option value="NAARKJJ">광주</option>
						                                        <option value="NAARKJK">군산</option>
																<option value="NAARKSS">김포</option>
						                                        <option value="NAARKPK">김해/부산</option>
						                                        <option value="NAARKTN">대구</option>
						                                        <option value="NAARKJB">무안</option>
						                                        <option value="NAARKPS">사천</option>
						                                        <option value="NAARKNY">양양</option>
						                                        <option value="NAARKJY">여수</option>
						                                        <option value="NAARKPU">울산</option>
						                                        <option value="NAARKNW">원주</option>
						                                        <option value="NAARKSI">인천</option>
						                                        <option value="NAARKPC">제주</option>
						                                        <option value="NAARKTU">청주</option>
						                                        <option value="NAARKTH">포항</option>
															</select>
														</section>
													</div>
													<div class="date_div">
														<div class="col-sm-12 mt" id="datetimepicker_start">
															<div class="input-field">
																<label for="date-start" style="margin-bottom: 10px;">출발일 (필수)</label>
																<input type="text" class="form-control date_controll" id="date-start" name="date_start" placeholder="yyyymmdd"/>
															</div>
														</div>
													</div>
													<div class="col-sm-12 mt" style="margin-bottom: 60px;">
														<section>
															<label for="class" style="margin-bottom: 10px;">항공사 (선택)</label>
															<select class="cs-select cs-skin-border" id="airline" name="airline">
																<option value="N" disabled selected>항공사</option>
																<option value="AAR">아시아나항공</option>
																<option value="ABL">에어부산</option>
																<option value="ASV">에어서울</option>
																<option value="ESR">이스타항공</option>
																<option value="FGW">플라이강원</option>
																<option value="HGG">하이에어</option>
																<option value="JJA">제주항공</option>
																<option value="JNA">진에어</option>
																<option value="KAL">대한항공</option>
																<option value="TWB">티웨이항공</option>
															</select>
														</section>
													</div>
													<div class="col-xs-12">
														<input type="button" id="flightBtn" class="btn btn-primary btn-block" value="Search Flight">
													</div>
												</div>
											 </div>
										 </form>
										 <!-- form end -->
									</div>
								</div>
							</div>
							<!-- main text start -->
							<div class="desc2 animate-box">
								<div class="col-sm-7 col-sm-push-1 col-md-7 col-md-push-1" style="padding-right:20px;">
									<p>Developed by <a href="https://github.com/lusida0131/skylife" target="_blank" class="fh5co-site-name">SkyLife.git</a></p>
									<h2>SkyLife와 함께 <br>여행 준비를 시작하세요.</h2><br>
									<h3>원하는 날짜와 여행지를 선택하여, 최적의 항공편을 확인해보세요.</h3>
								</div>
							</div>
							<!-- main text end -->
						</div>
					</div>
				</div>
			</div>
		</div>


		<div id="fh5co-tours" class="fh5co-section-gray">
			<div class="container">
				<div class="row">
					<div class="col-md-8 col-md-offset-2 text-center heading-section animate-box">
						<h3>행복한 여행을 응원합니다.</h3>
						<p>SKYLIFE는 여행을 편하게 해줄 수 있는 여러 서비스들을 제공합니다.</p>
					</div>
				</div>
				<!-- service category start -->
				<div id="fh5co-features" style="padding-top:15px; padding-bottom:15px;">
					<div class="container">
						<div class="row">
							<div class="col-md-4 animate-box">
								<div class="feature-left">
									<span class="icon"><br><i class="icon-hotairballoon"></i></span>
									<div class="feature-copy">
										<h3>항공편 조회</h3>
										<p>출발지/목적지와 날짜만 있다면 어디든 갈 수 있습니다.</p>
										<p><a href="#">Learn More</a></p>
									</div>
								</div>
							</div>
							<div class="col-md-4 animate-box">
								<div class="feature-left">
									<span class="icon"><br><i class="icon-wallet"></i></span>
									<div class="feature-copy">
										<h3>항공권 예매</h3>
										<p>SKYLIFE만의 자체 서비스 구현으로 항공권을 예약할 수 있습니다.</p>
										<p><a href="/fs/wish">Learn More</a></p>
									</div>
								</div>
							</div>
							<div class="col-md-4 animate-box">
								<div class="feature-left">
									<span class="icon"><br><i class="icon-search"></i></span>
									<div class="feature-copy">
										<h3>공항 주차시설 실시간 확인</h3>
										<p>실시간으로 공항 주차시설을 조회하여 주차 가능한 잔여 좌석을 알아볼 수 있습니다.</p>
										<p><a href="/Park/park">Learn More</a></p>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-4 animate-box">
								<div class="feature-left">
									<span class="icon"><br><i class="icon-genius"></i></span>
									<div class="feature-copy">
										<h3>주변 시설 조회</h3>
										<p>주변에 있는 주유소/약국/은행/마트 등의 시설들을 보여줍니다.</p>
										<p><a href="/page/map">Learn More</a></p>
									</div>
								</div>
							</div>
							<div class="col-md-4 animate-box">
								<div class="feature-left">
									<span class="icon"><br><i class="icon-wine"></i></span>
									<div class="feature-copy">
										<h3>맛집 검색</h3>
										<p>현재 위치를 기준으로 주변 맛집을 추천받거나 검색할 수 있습니다.</p>
										<p><a href="/page/map2">Learn More</a></p>
									</div>
								</div>
							</div>
							<div class="col-md-4 animate-box">
								<div class="feature-left">
									<span class="icon"><br><i class="icon-chat"></i></span>
									<div class="feature-copy">
										<h3>커뮤니티</h3>
										<p>SKYLIFE만의 자체 커뮤니티입니다. 나만의 여행 이야기를 공유하고, 타인의 이야기를 들어보세요.</p>
										<p><a href="/page/board">Learn More</a></p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- service category end -->
			</div>
		</div>

		<!-- park list start -->
		<div class="container">
			<div class="row" style="margin:20px;">
				<div class="col-md-8 col-md-offset-2 text-center heading-section animate-box" style="margin-top:35px; margin-bottom:25px;">
					<h3>주차장 목록</h3>
					<p style="margin-bottom: 15px;">실시간 주차장 정보를 조회할 수 있습니다.</p>
				</div>
			</div>
		</div>
		<div id="fh5co-destination">
			<div class="tour-fluid">
				<div class="row">
					<div class="col-md-12">
						<ul id="fh5co-destination-list" class="animate-box">
							<li class="one-forth text-center" style="background-image: url(${pageContext.request.contextPath}/resources/images/GMP.jpg); border: 1px solid;">
								<a href="/Park/GMPList">
									<div class="case-studies-summary">
										<br><br><br><br><br>
										<span>실시간 주차정보 >></span>
									</div>
								</a>
							</li>
							<li class="one-forth text-center" style="background-image: url(${pageContext.request.contextPath}/resources/images/PUS.jpg); border: 1px solid;">
								<a href="/Park/PUSList">
									<div class="case-studies-summary">
										<br><br><br><br><br>
										<span>실시간 주차정보 >></span>
									</div>
								</a>
							</li>
							<li class="one-forth text-center" style="background-image: url(${pageContext.request.contextPath}/resources/images/CJU.jpg); border: 1px solid;">
								<a href="/Park/CJUList">
									<div class="case-studies-summary">
										<br><br><br><br><br>
										<span>실시간 주차정보 >></span>
									</div>
								</a>
							</li>
							<li class="one-forth text-center" style="background-image: url(${pageContext.request.contextPath}/resources/images/TAE.jpg); border: 1px solid;">
								<a href="/Park/TAEList">
									<div class="case-studies-summary">
										<br><br><br><br><br>
										<span>실시간 주차정보 >></span>
									</div>
								</a>
							</li>

							<li class="one-forth text-center" style="background-image: url(${pageContext.request.contextPath}/resources/images/CJJ.jpg); border: 1px solid;">
								<a href="/Park/CJJList">
									<div class="case-studies-summary">
										<br><br><br><br><br>
										<span>실시간 주차정보 >></span>
									</div>
								</a>
							</li>
							<li class="one-half text-center" style="background-image: url(${pageContext.request.contextPath}/resources/images/ICN.jpg); border: 1px solid;">
								<a href="/Park/ICNList">
									<div class="case-studies-summary">
									<br><br><br><br><br>
										<span>해당 공항의 주차정보를 알고싶으면 클릭해주세요</span>
									</div>
								</a>
							</li>
							<li class="one-forth text-center" style="background-image: url(${pageContext.request.contextPath}/resources/images/KWJ.jpg); border: 1px solid;">
								<a href="/Park/KWJList">
									<div class="case-studies-summary">
										<br><br><br><br><br>
										<span>실시간 주차정보 >></span>
									</div>
								</a>
							</li>
							<li class="one-forth text-center" style="background-image: url(${pageContext.request.contextPath}/resources/images/RCU.jpg); border: 1px solid;">
								<a href="/Park/RSUList">
									<div class="case-studies-summary">
										<br><br><br><br><br>
										<span>실시간 주차정보 >></span>
									</div>
								</a>
							</li>
							<li class="one-forth text-center" style="background-image: url(${pageContext.request.contextPath}/resources/images/USN.jpg); border: 1px solid;">
								<a href="/Park/USNList">
									<div class="case-studies-summary">
										<br><br><br><br><br>
										<span>실시간 주차정보 >></span>
									</div>
								</a>
							</li>
							<li class="one-forth text-center" style="background-image: url(${pageContext.request.contextPath}/resources/images/KUV.jpg); border: 1px solid;">
								<a href="/Park/KUVList">
									<div class="case-studies-summary">
										<br><br><br><br><br>
										<span>실시간 주차정보 >></span>
									</div>
								</a>
							</li>
							<li class="one-forth text-center" style="background-image: url(${pageContext.request.contextPath}/resources/images/WJU.jpg); border: 1px solid;">
								<a href="/Park/WJUList">
									<div class="case-studies-summary">
										<br><br><br><br><br>
										<span>실시간 주차정보 >></span>
									</div>
								</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<!-- park list end -->


	<script type="text/javascript">

		$(document).ready(function(e){
			$('#flightBtn').click(function(){
				if($.trim($('#from_place').val()) === "") {
				    $('#from_place').focus();
					alert("출발지를 입력해주세요.");
				}
				else if($.trim($('#to_place').val()) === "") {
				    $('#to_place').focus();
					alert("도착지를 입력해주세요.");
				}
				/* else if($.trim($('#date_start').val()) === "") {
				    $('#date_start').focus();
					alert("출발일을 입력해주세요.");
				}
				else if($.trim($('#date_end').val()) === "") {
				    $('#date_end').focus();
					alert("도착일을 입력해주세요.");
				} */
				else {
					$('#flightFrm').submit();
				}
			});
		});
	</script>



<%@ include file="../layout/footer.jsp"%>