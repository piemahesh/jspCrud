/**
 * 
 */
console.log("im linked");

const deletebtns = document.querySelectorAll("#deleteBtn");

deletebtns.forEach((deleteBtn, i) => {
	deleteBtn.addEventListener("click", () => {
		const wishListId = deleteBtn.getAttribute("wishListId");
		console.log(wishListId)
		const confirmation = confirm("are you want to delete the particular wishlists")
		if (confirmation) {
			let aTag = document.createElement("a");
			aTag.setAttribute("href", "/crud_proj/wishList/delete/" + wishListId);
			aTag.style.display = "hidden";
			document.body.appendChild(aTag);
			aTag.click();
		}
	})
})
