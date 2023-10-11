/**
 * Confirmar a exclusao de um contato
 */

function confirmar() {
	let resposta = confirm("Confirma a exclusão deste Livro?")
	if (resposta === true) {
		window.location.href = "delete?id=" + id
	}
}