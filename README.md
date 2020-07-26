# RetrofitExample
Retrofit Example

+ RecyclerView

---------------------------------------------------------------------------------------------------

KOTLIN RecyclerView Adapter

...

class TodoAdapter(private val list: List<Todo>) :
    RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_item, parent, false)
        return TodoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.txtV1.text = list[position].id.toString()
        holder.txtV2.text = list[position].title
    }

    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtV1: TextView = itemView.findViewById<TextView>(R.id.textViewa)
        var txtV2: TextView = itemView.findViewById<TextView>(R.id.textViewb)
    }
}
