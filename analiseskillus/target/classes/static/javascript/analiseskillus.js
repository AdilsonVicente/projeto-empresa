var AnaliseSkillus = AnaliseSkillus || {};

AnaliseSkillus.MaskDate = (function() {
	
	function MaskDate() {
		this.inputDate = $('.js-date');
	}
	
	MaskDate.prototype.enable = function() {
		this.inputDate.mask('00/00/0000');
		this.inputDate.datepicker({
			orientation: 'bottom',
			language: 'pt-BR',
			autoclose: true
		});
	}
	
	return MaskDate;
}());


$(function() {
	var maskDate = new AnaliseSkillus.MaskDate();
	maskDate.enable();
});