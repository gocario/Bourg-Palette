



		for (int x = 0; x < width; x++)
		{
			for (int y = 0; y < height; y++)
			{
				[ ... ]
			}
		}


		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				[ ... ]
			}
		}



		for (int row = 0; row < width; row++)
		{
			for (int col = 0; col < height; col++)
			{
				[ ... ]
			}
		}
		











// if (obj.GetType() == typeof(WhatIWant))


		public override bool equals(Object obj)
		{
			if (obj is Foo)
			{
				Foo that = (Foo) obj;
				return that.bar == this.bar;

				return this.bar == that.bar
			}
			return false;
		}
		
// return super.equals(obj)



		@Override
		public boolean equals(Object obj)
		{
			if (obj instanceof Foo)
			{
				Foo that = (Foo) obj;
				return that.bar == this.bar;
			}
			return false;
		}