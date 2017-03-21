// function handleLoginRequest
//original
/*function verificar(xhr, status, args, dlg, tbl) {
	if (args.validationFailed) {
		PF(dlg).jq.effect("shake", {
			times : 5
		}, 100);
	} else {
		PF(dlg).hide();
		PF(tbl).clearFilters();
	}
 }*/

// teste próprio
function verificar(xhr, status, args, dlg, tbl) {
	if (!args.validationFailed) {
		PF(dlg).hide();
		PF(tbl).clearFilters();
	}
}
