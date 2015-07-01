$(function() {
	//===== Alert windows =====//

	$(".bAlert").click( function() {
		jAlert('This is a custom alert box. Title and this text can be easily editted', 'Alert Dialog Sample');
	});
	
	$(".bConfirm").click( function() {
		jConfirm('Can you confirm this?', 'Confirmation Dialog', function(r) {
			jAlert('Confirmed: ' + r, 'Confirmation Results');
		});
	});
	
	$(".bPromt").click( function() {
		jPrompt('Type something:', 'Prefilled value', 'Prompt Dialog', function(r) {
			if( r ) alert('You entered ' + r);
		});
	});
	
	$(".bHtml").click( function() {
		jAlert('You can use HTML, such as <strong>bold</strong>, <em>italics</em>, and <u>underline</u>!');
	});


	//===== Accordion =====//		
	
	$('div.menu_body:eq(0)').show();
	$('.acc .head:eq(0)').show().css({color:"#2B6893"});
	
	$(".acc .head").click(function() {	
		$(this).css({color:"#2B6893"}).next("div.menu_body").slideToggle(300).siblings("div.menu_body").slideUp("slow");
		$(this).siblings().css({color:"#404040"});
	});
	
	//===== ToTop =====//

	$().UItoTop({ easingType: 'easeOutQuart' });	
	
	
	//===== Spinner options =====//
	
	var itemList = [
		{url: "http://ejohn.org", title: "John Resig"},
		{url: "http://bassistance.de/", title: "J&ouml;rn Zaefferer"},
		{url: "http://snook.ca/jonathan/", title: "Jonathan Snook"},
		{url: "http://rdworth.org/", title: "Richard Worth"},
		{url: "http://www.paulbakaus.com/", title: "Paul Bakaus"},
		{url: "http://www.yehudakatz.com/", title: "Yehuda Katz"},
		{url: "http://www.azarask.in/", title: "Aza Raskin"},
		{url: "http://www.karlswedberg.com/", title: "Karl Swedberg"},
		{url: "http://scottjehl.com/", title: "Scott Jehl"},
		{url: "http://jdsharp.us/", title: "Jonathan Sharp"},
		{url: "http://www.kevinhoyt.org/", title: "Kevin Hoyt"},
		{url: "http://www.codylindley.com/", title: "Cody Lindley"},
		{url: "http://malsup.com/jquery/", title: "Mike Alsup"}
	];

	var opts = {
		's1': {decimals:2},
		's2': {stepping: 0.25},
		's3': {currency: '$'},
		's4': {},
		's5': {
			//
			// Two methods of adding external items to the spinner
			//
			// method 1: on initalisation call the add method directly and format html manually
			init: function(e, ui) {
				for (var i=0; i<itemList.length; i++) {
					ui.add('<a href="'+ itemList[i].url +'" target="_blank">'+ itemList[i].title +'</a>');
				}
			},

			// method 2: use the format and items options in combination
			format: '<a href="%(url)" target="_blank">%(title)</a>',
			items: itemList
		}
	};

	for (var n in opts)
		$("#"+n).spinner(opts[n]);

	$("button").click(function(e){
		var ns = $(this).attr('id').match(/(s\d)\-(\w+)$/);
		if (ns != null)
			$('#'+ns[1]).spinner( (ns[2] == 'create') ? opts[ns[1]] : ns[2]);
	});



	//===== Dynamic data table =====//

	oTable = $('#example').dataTable({
		"bJQueryUI": true,
		"sPaginationType": "full_numbers",
		"sDom": '<""f>t<"F"lp>',
                "aaSorting": [[ 0, "desc" ]]
	});
	oTable = $('#userz').dataTable({
		"bJQueryUI": true,
		"sPaginationType": "full_numbers",
		"sDom": '<""f>t<"F"lp>'
	});

	
	//===== Form elements styling =====//
	
	$('form').jqTransform({imgPath:'../images/forms'});
	
	
	//===== Form validation engine =====//

	$("#frmMofidyEdition").validationEngine();
	
        $("#frmLogin").validationEngine();
        
         $("#frmReport").validationEngine();
	//===== Datepickers =====//

	$( ".datepicker" ).datepicker({ 
		defaultDate: +7,
		autoSize: true,
		appendText: '(dd-mm-yyyy)',
		dateFormat: 'dd-mm-yy'
	});	

	$( ".datepickerInline" ).datepicker({ 
		defaultDate: +7,
		autoSize: true,
		appendText: '(dd-mm-yyyy)',
		dateFormat: 'dd-mm-yy',
		numberOfMonths: 1
	});	


	//===== Progressbar (Jquery UI) =====//

	$( "#progressbar" ).progressbar({
			value: 37
	});
		
		
	//===== Tooltip =====//
		
	$('.leftDir').tipsy({fade: true, gravity: 'e'});
	$('.rightDir').tipsy({fade: true, gravity: 'w'});
	$('.topDir').tipsy({fade: true, gravity: 's'});
	$('.botDir').tipsy({fade: true, gravity: 'n'});

		
	//===== Information boxes =====//
		
	$(".hideit").click(function() {
		$(this).fadeOut(400);
	});
	

	//=====Resizable table columns =====//
	
	var onSampleResized = function(e){
		var columns = $(e.currentTarget).find("th");
		var msg = "columns widths: ";
		columns.each(function(){ msg += $(this).width() + "px; "; })
	};	

	$(".resize").colResizable({
		liveDrag:true, 
		gripInnerHtml:"<div class='grip'></div>", 
		draggingClass:"dragging", 
		onResize:onSampleResized});


	//===== Left navigation submenu animation =====//	
		
	$("ul.sub li a").hover(function() {
	$(this).stop().animate({ color: "#3a6fa5" }, 400);
	},function() {
	$(this).stop().animate({ color: "#494949" }, 400);
	});
	
	
	//===== Image gallery control buttons =====//

	 $(".pics ul li").hover(
		  function() { $(this).children(".actions").show("fade", 200); },
		  function() { $(this).children(".actions").hide("fade", 200); }
	 );
	

	
	//===== Autogrowing textarea =====//
	
	$(".auto").autoGrow();
	

	//===== Autotabs. Inline data rows =====//

	$('.onlyNums input').autotab_magic().autotab_filter('numeric');
	$('.onlyText input').autotab_magic().autotab_filter('text');
	$('.onlyAlpha input').autotab_magic().autotab_filter('alpha');
	$('.onlyRegex input').autotab_magic().autotab_filter({ format: 'custom', pattern: '[^0-9\.]' });
	$('.allUpper input').autotab_magic().autotab_filter({ format: 'alphanumeric', uppercase: true });
	
	
	//===== jQuery UI sliders =====//	
	
	$( ".uiSlider" ).slider();
	
	$( ".uiSliderInc" ).slider({
		value:100,
		min: 0,
		max: 500,
		step: 50,
		slide: function( event, ui ) {
			$( "#amount" ).val( "$" + ui.value );
		}
	});
	$( "#amount" ).val( "$" + $( ".uiSliderInc" ).slider( "value" ) );
		
	$( ".uiRangeSlider" ).slider({
		range: true,
		min: 0,
		max: 500,
		values: [ 75, 300 ],
		slide: function( event, ui ) {
			$( "#rangeAmount" ).val( "$" + ui.values[ 0 ] + " - $" + ui.values[ 1 ] );
		}
	});
	$( "#rangeAmount" ).val( "$" + $( ".uiRangeSlider" ).slider( "values", 0 ) +" - $" + $( ".uiRangeSlider" ).slider( "values", 1 ));
			
	$( ".uiMinRange" ).slider({
		range: "min",
		value: 37,
		min: 1,
		max: 700,
		slide: function( event, ui ) {
			$( "#minRangeAmount" ).val( "$" + ui.value );
		}
	});
	$( "#minRangeAmount" ).val( "$" + $( ".uiMinRange" ).slider( "value" ) );
	
	$( ".uiMaxRange" ).slider({
		range: "max",
		min: 1,
		max: 100,
		value: 20,
		slide: function( event, ui ) {
			$( "#maxRangeAmount" ).val( ui.value );
		}
	});
	$( "#maxRangeAmount" ).val( $( ".uiMaxRange" ).slider( "value" ) );	
	
	
	
	$( "#eq > span" ).each(function() {
		// read initial values from markup and remove that
		var value = parseInt( $( this ).text(), 10 );
		$( this ).empty().slider({
			value: value,
			range: "min",
			animate: true,
			orientation: "vertical"
		});
	});
	
	
	//===== Breadcrumbs =====//	

	//===== Autofocus =====//	
	
	$('.autoF').focus();


	//===== Tabs =====//
		
	$.fn.simpleTabs = function(){ 
	
		//Default Action
		$(this).find(".tab_content").hide(); //Hide all content
		$(this).find("ul.tabs li:first").addClass("activeTab").show(); //Activate first tab
		$(this).find(".tab_content:first").show(); //Show first tab content
	
		//On Click Event
		$("ul.tabs li").click(function() {
			$(this).parent().parent().find("ul.tabs li").removeClass("activeTab"); //Remove any "active" class
			$(this).addClass("activeTab"); //Add "active" class to selected tab
			$(this).parent().parent().find(".tab_content").hide(); //Hide all tab content
			var activeTab = $(this).find("a").attr("href"); //Find the rel attribute value to identify the active tab + content
			$(activeTab).show(); //Fade in the active content
			return false;
		});
	
	};//end function

	$("div[class^='widget']").simpleTabs(); //Run function on any div with class name of "Simple Tabs"


	//===== Placeholder for all browsers =====//
	
	$("input").each(
		function(){
			if($(this).val()=="" && $(this).attr("placeholder")!=""){
			$(this).val($(this).attr("placeholder"));
			$(this).focus(function(){
				if($(this).val()==$(this).attr("placeholder")) $(this).val("");
			});
			$(this).blur(function(){
				if($(this).val()=="") $(this).val($(this).attr("placeholder"));
			});
		}
	});


	//===== User nav dropdown =====//		

	$('.dd').click(function () {
		$('ul.menu_body').slideToggle(100);
	});
	
	$('.acts').click(function () {
		$('ul.actsBody').slideToggle(100);
	});
	
	
	//===== Collapsible elements management =====//
	
	$('.active').collapsible({
		defaultOpen: 'current',
		cookieName: 'nav',
		speed: 300
	});
	
	$('.exp').collapsible({
		defaultOpen: 'current',
		cookieName: 'navAct',
		cssOpen: 'active',
		cssClose: 'inactive',
		speed: 300
	});

	$('.opened').collapsible({
		defaultOpen: 'opened,toggleOpened',
		cssOpen: 'inactive',
		cssClose: 'normal',
		speed: 200
	});

	$('.closed').collapsible({
		defaultOpen: '',
		cssOpen: 'inactive',
		cssClose: 'normal',
		speed: 200
	});
	

});