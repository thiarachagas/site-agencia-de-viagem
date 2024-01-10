using DreamTravel.Data;
using DreamTravel.Models;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace DreamTravel.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class DestinoController : ControllerBase
    {
        private readonly DataContext _context;

        public DestinoController(DataContext context)
        {
            _context = context;
        }

        [HttpGet]
        public async Task<ActionResult<List<Destino>>> GetDestinos()
        {
            var destinos = await _context.Destinos.ToListAsync();

            return Ok(destinos);
        }
    }
}
