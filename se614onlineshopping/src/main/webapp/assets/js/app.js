$(function() {
	// Switching active page
	switch (menu) {
	case 'Contact us':
		$('#contact').addClass('active');
		break;
	case 'About us':
		$('#about').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	default:
		if(menu =="home") break;
		$('#listProducts').addClass('active');
		$('#a_'+menu).addClass('active');
		break;
	}

});