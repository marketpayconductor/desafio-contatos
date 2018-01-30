function search() {
    var input, filter, table, tr, td, i;
    input = document.getElementById("search");
    filter = input.value.toUpperCase();
    table = document.getElementById("contatosTable");
    tr = table.getElementsByTagName("tr");
    for (i = 0; i < tr.length; i++) {
        nome = tr[i].getElementsByTagName("td")[0];
        endereco = tr[i].getElementsByTagName("td")[1];
        fone = tr[i].getElementsByTagName("td")[2];
        if (nome || endereco || fone) {
            if (nome.innerHTML.toUpperCase().indexOf(filter) > -1
                || endereco.innerHTML.toUpperCase().indexOf(filter) > -1
                || fone.innerHTML.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}