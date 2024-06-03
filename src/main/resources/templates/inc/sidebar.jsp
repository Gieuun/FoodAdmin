<%@ page contentType="text/html;charset=UTF-8"%>
<aside class="main-sidebar sidebar-dark-primary elevation-4">
	<!-- Brand Logo -->
	<a href="/" class="brand-link"> <img
		src="/static/admin/dist/img/AdminLTELogo.png" alt="AdminLTE Logo"
		class="brand-image img-circle elevation-3" style="opacity: .8">
		<span class="brand-text font-weight-light">영화관리</span>
	</a>

	<!-- Sidebar -->
	<div class="sidebar">
		<!-- Sidebar user panel (optional) -->
		<div class="user-panel mt-3 pb-3 mb-3 d-flex">
			<div class="image">
				<img src="/static/admin/dist/img/user2-160x160.jpg"
					class="img-circle elevation-2" alt="User Image">
			</div>
			<div class="info">
				<a href="#" class="d-block">홍길동</a>
			</div>
		</div>

		<!-- SidebarSearch Form -->
		<div class="form-inline">
			<div class="input-group" data-widget="sidebar-search">
				<input class="form-control form-control-sidebar" type="search"
					placeholder="Search" aria-label="Search">
				<div class="input-group-append">
					<button class="btn btn-sidebar">
						<i class="fas fa-search fa-fw"></i>
					</button>
				</div>
			</div>
		</div>

		<!-- Sidebar Menu -->
		<nav class="mt-2">
			<ul class="nav nav-pills nav-sidebar flex-column"
				data-widget="treeview" role="menu" data-accordion="false">
				<!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
				
				<!-- 상품관리 메뉴 -->               
				<li class="nav-item menu-open">
					<a href="#"class="nav-link"> 
						<i class="nav-icon fas fa-tachometer-alt"></i>
						<p>
							영화 관리 <i class="right fas fa-angle-left"></i>
						</p>
					</a>
					<ul class="nav nav-treeview">
						<li class="nav-item">
							<a href="/movie/api/list" class="nav-link"> 
								<i class="far fa-circle nav-icon"></i>
								<p>진흥위원회영화</p>
							</a>
						</li>
						<li class="nav-item">
							<a href="/movie/site/list" class="nav-link"> 
								<i class="far fa-circle nav-icon"></i>
								<p>사이트등록영화</p>
							</a>
						</li>
						<li class="nav-item">
							<a href="/movie/registform" class="nav-link"> 
								<i class="far fa-circle nav-icon"></i>
								<p>영화 등록</p>
							</a>
						</li>
					</ul>
				</li>
			
				<!-- 회원관리 메뉴 -->               
				<li class="nav-item menu-open">
					<a href="#"class="nav-link"> 
						<i class="nav-icon fas fa-tachometer-alt"></i>
						<p>
							회원관리 <i class="right fas fa-angle-left"></i>
						</p>
					</a>
					<ul class="nav nav-treeview">
						<li class="nav-item">
							<a href="./index.html" class="nav-link"> 
								<i class="far fa-circle nav-icon"></i>
								<p>회원목록</p>
							</a>
						</li>
						<li class="nav-item">
							<a href="./index.html" class="nav-link"> 
								<i class="far fa-circle nav-icon"></i>
								<p>상품등록</p>
							</a>
						</li>
					</ul>
				</li>
			
				<!-- 주문관리 메뉴 -->               
				<li class="nav-item menu-open">
					<a href="#"class="nav-link"> 
						<i class="nav-icon fas fa-tachometer-alt"></i>
						<p>
							주문관리 <i class="right fas fa-angle-left"></i>
						</p>
					</a>
					<ul class="nav nav-treeview">
						<li class="nav-item">
							<a href="./index.html" class="nav-link"> 
								<i class="far fa-circle nav-icon"></i>
								<p>주문목록</p>
							</a>
						</li>
						<li class="nav-item">
							<a href="./index.html" class="nav-link"> 
								<i class="far fa-circle nav-icon"></i>
								<p>상품등록</p>
							</a>
						</li>
					</ul>
				</li>
			
			
			</ul>
		</nav>
		<!-- /.sidebar-menu -->
	</div>
</aside>