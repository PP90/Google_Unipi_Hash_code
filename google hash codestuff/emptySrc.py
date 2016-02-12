##
def get_busy_day_info(first_row):

	pos=first_row.find(' ')
	rows_number=first_row[0:pos]
	rest_of_stuff=first_row[pos+1:len(first_row)-1]

	pos=rest_of_stuff.find(' ')
	cols_number=rest_of_stuff[0:pos]
	rest_of_stuff=rest_of_stuff[pos+1:len(first_row)-1]
	
	pos=rest_of_stuff.find(' ')
	drones_number=rest_of_stuff[0:pos]
	rest_of_stuff=rest_of_stuff[pos+1:len(first_row)-1]

	pos=rest_of_stuff.find(' ')
	deadline=rest_of_stuff[0:pos]
	rest_of_stuff=rest_of_stuff[pos+1:len(first_row)-1]

	max_load_drone=rest_of_stuff

	return int(rows_number), int(cols_number), int(drones_number), int(deadline), int(max_load_drone)



def get_different_types_product_number(raw_content):
	pos=raw_content[0].find('\n')
	element=raw_content[0][0:pos]
	return element


def get_warehouse_numbers(raw_content):
	pos=raw_content[0].find('\n')
	warehouses_number=raw_content[0][0:pos]
	return warehouses_number

def get_orders_number(raw_content):
	pos=raw_content[0].find('\n')
	orders_numbers=raw_content[0][0:pos]
	return orders_numbers

def get_customers_orders_number(raw_content):
	pos=raw_content[0].find('\n')
	warehouses_number=raw_content[0][0:pos]
	return warehouses_number

def import_file(filename):##The file content is raw format. It is needed to parse
	content=list(open(filename))
	return content

def get_product_types(raw_content, n_products_types):
	product_types_list=[]
	raw_format_product_list=raw_content[0]
	types_product_list_length=len(raw_format_product_list)
	#print raw_format_product_list
	for x in range(0, n_products_types):
		if(x==n_products_types-1):
			product_types_list.append(raw_format_product_list)
			break

		pos=raw_format_product_list.find(' ')
		product_code=raw_format_product_list[0:pos]
		product_types_list.append(product_code)
		tmp=raw_format_product_list[pos+1:types_product_list_length-1]	
		raw_format_product_list=tmp		
		
def get_coordinates(raw_content):
	pos=raw_content[0].find(' ')
	y=raw_content[0][pos+1:len(raw_content)-1]
	x=raw_content[0][0:pos]
	return int(x), int(y)

def get_orders(raw_content, n_ordered_products):
	orders_not_parsed=raw_content[0]
	raw_format_product_list=raw_content[0]
	orders_list=[]

	for x in range(0,n_ordered_products):
		if(i==n_ordered_products-1):
			availability_types_list.append(raw_format_product_list)
			break

		pos=orders_not_parsed.find(' ')
		order=orders_not_parsed[0:pos]
		availability_types_list.append(order)
		tmp=orders_not_parsed[pos+1:types_product_list_length-1]	
		orders_not_parsed=tmp			

	print orders_list


##here
def get_lists_customers_orders(raw_content, n_orders):

	for x in range(0, int(n_orders)):
		orders_list_single_customer=[]
		x,y=get_coordinates(raw_content)		
		raw_content.pop(0)
		n_ordered_products=get_orders_number(raw_content)
		raw_content.pop(0)
		
		
			#####TO BE DONE, MAYBE NEVER.
			##TO LIST THE NUMBER OF ORDERS FROM THE FILE.

##

def get_availability_product(n_products_types, raw_content):
	availability_types_list=[]
	raw_format_product_list=raw_content[0]
	types_product_list_length=len(raw_format_product_list)

	for i in range(0,n_products_types):
		if(i==n_products_types-1):
			availability_types_list.append(raw_format_product_list)
			break

		pos=raw_format_product_list.find(' ')
		availability_quantity=raw_format_product_list[0:pos]
		availability_types_list.append(availability_quantity)
		tmp=raw_format_product_list[pos+1:types_product_list_length-1]	
		raw_format_product_list=tmp	

	return availability_types_list

def get_warehouses_availability(n_warehouses, n_products_types, raw_content):
	availability_lists=[]
	for i in range(0,n_warehouses):
		x,y=get_coordinates(raw_content)
		raw_content.pop(0)
		single_availability_list=get_availability_product(n_products_types, raw_content)
		availability_lists.append(single_availability_list)
		raw_content.pop(0)

	return availability_lists

def test():
	raw_content=import_file("busy_day.in")
	rows, columns, drones_number, deadline, max_load_drone=get_busy_day_info(raw_content[0])
	raw_content.pop(0)##The first row is removed
	n_products_types=get_different_types_product_number(raw_content)##
	raw_content.pop(0)##The second row is removed
	list_product_types=get_product_types(raw_content, int(n_products_types))
	raw_content.pop(0)##The third row is removed
	n_warehouses=get_warehouse_numbers(raw_content)
	raw_content.pop(0)##The third row is removed
	availability_lists=get_warehouses_availability(int(n_warehouses), int(n_products_types), raw_content)
	n_customers_orders=get_customers_orders_number(raw_content)
	raw_content.pop(0)##The third row is removed
	get_lists_customers_orders(raw_content, n_customers_orders)
	


		
	
test()
