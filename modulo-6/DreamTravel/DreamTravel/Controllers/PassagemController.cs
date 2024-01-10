using DreamTravel.Data;
using DreamTravel.Models;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace DreamTravel.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class PassagemController : ControllerBase
    {
        private readonly DataContext _context;

        public PassagemController(DataContext context)
        {
            _context = context;
        }

        [HttpGet]
        public async Task<ActionResult<List<Passagem>>> GetAllPassagens()
        {
            var result = await _context.Passagens
                .Include(passagem => passagem.CompanhiaAerea)
                .Include(passagem => passagem.Destino)
                .Include(passagem => passagem.Promocao)
                .ToListAsync();
            
            return Ok(result);
        }
    }
}
