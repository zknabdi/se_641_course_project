<div class="container">
	<div class="row">

		<!-- Show sidebar -->
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp"%>
		</div>

		<!-- Show actual products -->
		<div class="col-md-9">
			<!-- Breadcrum component -->
			<div class="row">
				<div class="col-lg-12">
					<c:if test="${userClickAllProducts}==true">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextRoot}/home">Home
							</a></li>
							<li class="breadcrumb-item active">All Products</li>

						</ol>
					</c:if>

					<c:if test="${userClickCategoryProducts}==true">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextRoot}/home">Home </a></li>
							<li class="breadcrumb-item active">Category</li>
							<li class="breadcrumb-item active">${category.name}</li>
						</ol>
					<!-- 	<nav aria-label="breadcrumb">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<li class="breadcrumb-item"><a href="#">Library</a></li>
								<li class="breadcrumb-item active" aria-current="page">Data</li>
							</ol>
						</nav> -->
					</c:if>
				</div>
			</div>
		</div>
	</div>
</div>