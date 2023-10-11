/**
 * Validar campos obrigatorios
 */

function validar() {
	
	let titulo = frmLivro.titulo.value
	let autor = frmLivro.autor.value
	let editora = frmLivro.editora.value
	let isbn = frmLivro.isbn.value
	if (titulo === "") {
		alert('Preencha o campo Título')
		frmLivro.titulo.focus()
		return false
	} else if (autor === "") {
		alert('Preencha o campo Autor')
		frmLivro.autor.focus()
		return false
	} else if (editora === "") {
		alert('Preencha o campo Editora')
		frmLivro.editora.focus()
		return false
	} else if (isbn === "") {
		alert('Preencha o campo ISBN')
		frmLivro.isbn.focus()
		return false
	} else {
		document.forms["frmLivro"].submit()
	}
}