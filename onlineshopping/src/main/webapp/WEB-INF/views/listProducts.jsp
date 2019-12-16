<div class="container">
	<div class="row">
		<!-- 	would be to display the sidebar -->
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp"%>
		</div>
		<!-- 	would be to display the actual products of categeory -->
		<div class="col-md-9">
			<!-- 		added breadcrum compoenent -->
			<div class="row">
				<div class="col-lg-12">
					<c:if test="${userClickAllProducts==true}">
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">/All Products</li>
						</ol>
					</c:if>

					<c:if test="${userClickCategeoryProducts==true}">
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">/Categeory</li>
							<li class="active">/${categeory.name}</li>
						</ol>
					</c:if>
				</div>
			</div>
		</div>


	</div>

</div>